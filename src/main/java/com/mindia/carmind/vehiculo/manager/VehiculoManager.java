package com.mindia.carmind.vehiculo.manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.LogEvaluacion;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.entities.VehiculoEvaluacion;
import com.mindia.carmind.entities.interfaces.IVehiculo;
import com.mindia.carmind.evaluacion.manager.EvaluacionManager;
import com.mindia.carmind.evaluacion.persistence.LogEvaluacionRepository;
import com.mindia.carmind.evaluacion.pojo.EvaluacionView;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.vehiculo.persistence.VehiculoEvaluacionRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.AsignacionPojo;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VehiculoManager implements IVehiculo {
    Convertions c;

    @Autowired
    VehiculosRepository repository;

    @Autowired
    VehiculoEvaluacionRepository vehiculoEvaluacionRepository;

    @Autowired
    LogEvaluacionRepository logEvaluacionRepository;

    @Autowired
    EvaluacionManager evaluacionManager;

    public void altaVehiculo(AltaPojo pojo) {

        pojo.validate();

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setColor(pojo.getColor());
        vehiculo.setFechaService(pojo.getFechaService());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());

        repository.save(vehiculo);
    }

    public void modificarVehiculo(ModificarPojo pojo) {

        pojo.validate();

        Vehiculo vehiculo = repository.getById(pojo.getId());

        if(vehiculo == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id incorrecto");
        }

        vehiculo.setColor(pojo.getColor());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());

        repository.save(vehiculo);
    }

    public void bajaVehiculo(String id) {
        try {
            repository.deleteById(Integer.parseInt(id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("No se encontro la entidad Vehiculo con id " + id);
        }
    }

    public VehiculoView obtenerVehiculoById(String id) {
        Vehiculo v = repository.getById(Integer.parseInt(id));
        VehiculoView vehiculo = new VehiculoView(v);
        return vehiculo;
    }

    @Override
    public List<VehiculoView> getAllVehiculos() {
        List<Vehiculo> v = repository.findAll();
        return v.stream().map(VehiculoView::new).collect(Collectors.toList());
    }

    public void asignarEvaluacion(String vehiculoId, AsignacionPojo pojo){
        int intId = Integer.parseInt(vehiculoId);

        Vehiculo vehiculo = repository.getById(intId);

        Evaluacion evaluacion = evaluacionManager.getEvaluacionById(pojo.getIdEvaluacion() + "");
        
        //Tabla many-to-many
        VehiculoEvaluacion manyToMany = new VehiculoEvaluacion();
        manyToMany.setEvaluacionId(evaluacion.getId());
        manyToMany.setVehiculoId(vehiculo.getId());
        manyToMany.setIntervaloDias(pojo.getIntervalo_dias());

        

        try {
            LocalDate fechaInicio = LocalDate.parse(pojo.getFecha_inicio(), DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault()));
            manyToMany.setFechaInicio(fechaInicio);
        } catch (IllegalArgumentException | DateTimeParseException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid format of date");
        }

        vehiculoEvaluacionRepository.save(manyToMany);
    }

    public EvaluacionView checkVehiculo(int id){
        //Obtenemos el vehiculo
        Vehiculo vehiculo = repository.getById(id);

        //Obtenemos las evaluaciones de él
        List<VehiculoEvaluacion> vehiculoxEvaluacion = vehiculo.getListOfVehiculoEvaluacion();

        //Iteramos sobre ellas
        for (VehiculoEvaluacion vehiculoEvaluacion : vehiculoxEvaluacion) {
            
            //Obtenemos el ultimo log de la evaluacion
            LogEvaluacion log = logEvaluacionRepository.getLastLogById(vehiculoEvaluacion.getEvaluacionId());

            //Si el ultimo log es null, es porque nunca se hizo una evaluacion
            if(log != null){

                //Fecha del ultimo log
                LocalDate dateLog = log.getFecha();
                
                //Fecha de la proxima vez que se deberia realizar la evaluacion
                LocalDate fechaProxima = fechaProximoCheck(vehiculoEvaluacion);

                int intervaloDias = vehiculoEvaluacion.getIntervaloDias();

                //Si la fecha del log esta adelante de la ultima vez que se debio realizar la evaluacion
                if(dateLog.isAfter(fechaProxima.minusDays(intervaloDias)) || dateLog.isEqual(fechaProxima.minusDays(intervaloDias))){
                    //Damos un salto de iteracion. Salteandomos que devuelva la evaluacion.
                    break;
                }
            }

            //Devolvemos la evaluacion a realizar
            return evaluacionManager.getEvaluacionViewById(vehiculoEvaluacion.getEvaluacionId());
        }

        //Devolvemos null, ya que no tiene que hacer ninguna evaluacion.
        return null;
    }

    //-------------------------------------------------------------------------------------------------------------------------------

    /**
     * Calcula la proxima fecha de la evaluacion
     * 
     * @param vehiculoEvaluacion
     * @return proxima fecha de la evaluacion
     */
    private LocalDate fechaProximoCheck(VehiculoEvaluacion vehiculoEvaluacion){

        LocalDate hoy = LocalDate.now();

        LocalDate fechaPeriodo = vehiculoEvaluacion.getFechaInicio();

        int intervaloDias = vehiculoEvaluacion.getIntervaloDias();


        while (hoy.isAfter(fechaPeriodo)) {
            fechaPeriodo = fechaPeriodo.plusDays(intervaloDias);
        }

        return fechaPeriodo;
    }


}