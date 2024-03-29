package com.mindia.carmind.vehiculo.manager;

import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.mindia.carmind.entities.Documento;
import com.mindia.carmind.entities.Evaluacion;
import com.mindia.carmind.entities.LogEvaluacion;
import com.mindia.carmind.entities.LogUsoVehiculo;
import com.mindia.carmind.entities.Vehiculo;
import com.mindia.carmind.entities.VehiculoEvaluacion;
import com.mindia.carmind.evaluacion.manager.EvaluacionManager;
import com.mindia.carmind.evaluacion.persistence.LogEvaluacionRepository;
import com.mindia.carmind.evaluacion.pojo.LogEvaluacionView;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionLiteView;
import com.mindia.carmind.evaluacion.pojo.view.EvaluacionView;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.usuario.pojo.UsuarioView;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.vehiculo.persistence.DocumentoRepository;
import com.mindia.carmind.vehiculo.persistence.LogUsoVehiculoRepository;
import com.mindia.carmind.vehiculo.persistence.TipoDocumentoRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculoEvaluacionRepository;
import com.mindia.carmind.vehiculo.persistence.VehiculosRepository;
import com.mindia.carmind.vehiculo.pojo.AltaPojo;
import com.mindia.carmind.vehiculo.pojo.AsignacionPojo;
import com.mindia.carmind.vehiculo.pojo.DocumentoView;
import com.mindia.carmind.vehiculo.pojo.LogUsoVehiculoView;
import com.mindia.carmind.vehiculo.pojo.ModificarPojo;
import com.mindia.carmind.vehiculo.pojo.VehiculoView;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VehiculoManager {
    Convertions c;

    @Autowired
    VehiculosRepository repository;

    @Autowired
    VehiculoEvaluacionRepository vehiculoEvaluacionRepository;

    @Autowired
    LogEvaluacionRepository logEvaluacionRepository;

    @Autowired
    LogUsoVehiculoRepository logUsoVehiculoRepository;

    @Autowired
    EvaluacionManager evaluacionManager;

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    public void altaVehiculo(AltaPojo pojo) {

        pojo.validate();

        UsuarioView usuario = usuariosManager.getLoggeduser();

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setNombre(pojo.getNombre());

        if (pojo.getPatente() != null && !pojo.getPatente().isEmpty()) {

            vehiculo.setPatente(pojo.getPatente().trim().replaceAll(" ", "")); // TODO: Validate properties

            if (repository.findByPatente(vehiculo.getPatente()) != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patente duplicada");
            }
        }

        vehiculo.setEmpresaId(usuario.getEmpresa());
        vehiculo.setTipoVehiculo(pojo.getTipo());

        repository.save(vehiculo);
    }

    public void modificarVehiculo(ModificarPojo pojo) {

        pojo.validate();

        Vehiculo vehiculo = repository.getById(pojo.getId());

        if (vehiculo == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehiculo no encontrado");
        }

        vehiculo.setNombre(pojo.getNombre());
        vehiculo.setLinea(pojo.getLinea());
        vehiculo.setMarca(pojo.getMarca());
        vehiculo.setModelo(pojo.getModelo());
        vehiculo.setTipoVehiculo(pojo.getTipo());
        vehiculo.setKilometraje(pojo.getKilometraje());
        vehiculo.setPatente(pojo.getPatente());
        vehiculo.setImei(pojo.getImei());
        
        try{
            repository.save(vehiculo);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La patente o el imei deben ser únicos");
        }
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
        return armarVehiculoConPendientes(v, true);
    }

    public List<VehiculoView> getAllVehiculos() {
        UsuarioView usuario = usuariosManager.getLoggeduser();

        List<Vehiculo> v = repository.findByEmpresaIdOrderByUsuarioIdUsandoDesc(usuario.getEmpresa());
        return v.stream().map(vehic -> new VehiculoView(vehic, true)).collect(Collectors.toList());
    }

    public List<VehiculoView> getAllVehiculosWithPendientes() {
        UsuarioView usuario = usuariosManager.getLoggeduser();

        List<Vehiculo> v = repository.findByEmpresaId(usuario.getEmpresa());
        return v.stream().map(x -> armarVehiculoConPendientes(x, true)).collect(Collectors.toList());
    }

    public void asignarEvaluacion(String vehiculoId, AsignacionPojo pojo) {
        int intId = Integer.parseInt(vehiculoId);

        Vehiculo vehiculo = repository.getById(intId);

        Evaluacion evaluacion = evaluacionManager.getEvaluacionById(pojo.getIdEvaluacion() + "");

        // Tabla many-to-many
        VehiculoEvaluacion manyToMany = new VehiculoEvaluacion();
        manyToMany.setEvaluacionId(evaluacion.getId());
        manyToMany.setVehiculoId(vehiculo.getId());
        manyToMany.setIntervaloDias(pojo.getIntervalo_dias());

        try {
            LocalDate fechaInicio = LocalDate.parse(pojo.getFecha_inicio(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault()));
            manyToMany.setFechaInicio(fechaInicio);
        } catch (IllegalArgumentException | DateTimeParseException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid format of date");
        }

        vehiculoEvaluacionRepository.save(manyToMany);
    }

    public EvaluacionView checkVehiculo(int id) {
        // Obtenemos el vehiculo
        Vehiculo vehiculo = repository.getById(id);

        // Obtenemos las evaluaciones de él
        List<VehiculoEvaluacion> vehiculoxEvaluacion = vehiculo.getVehiculoevaluacionList();

        // Iteramos sobre ellas
        for (VehiculoEvaluacion vehiculoEvaluacion : vehiculoxEvaluacion) {

            // Obtenemos el ultimo log de la evaluacion
            LogEvaluacion log = logEvaluacionRepository.getLastLogById(vehiculoEvaluacion.getVehiculoId());

            // Si el ultimo log es null, es porque nunca se hizo una evaluacion
            if (log != null) {

                // Fecha del ultimo log
                LocalDate dateLog = log.getFecha().toLocalDate();

                // Fecha de la proxima vez que se deberia realizar la evaluacion
                LocalDate fechaProxima = fechaProximoCheck(vehiculoEvaluacion);

                int intervaloDias = vehiculoEvaluacion.getIntervaloDias();

                // Si la fecha del log esta adelante de la ultima vez que se debio realizar la
                // evaluacion
                if (dateLog.isAfter(fechaProxima.minusDays(intervaloDias))
                        || dateLog.isEqual(fechaProxima.minusDays(intervaloDias))) {
                    // Damos un salto de iteracion. Salteandomos que devuelva la evaluacion.
                    break;
                }
            }

            // Devolvemos la evaluacion a realizar
            return evaluacionManager.getEvaluacionViewById(vehiculoEvaluacion.getEvaluacionId());
        }

        // Devolvemos null, ya que no tiene que hacer ninguna evaluacion.
        return null;
    }

    @Transactional
    /***
     * 
     * @param id El id del vehiculo
     * @param time Puede ser null o no, es para indicar la fecha de inicio, si es por sincronizacion de datos
     */
    public void iniciarUso(Integer id, LocalDateTime time) {
        // Obtenemos el vehiculo
        Vehiculo vehiculo = repository.getById(id);

        // Obtenemos el usuario logeado
        UsuarioView loggedUser = usuariosManager.getLoggeduser();
        

        if (!(vehiculo.getEmpresaId() == loggedUser.getEmpresa())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este vehiculo no es de tu empresa.");
        }

        //Si empieza a usar un vehiculo que ya esta usando, no pasa nada
        if (vehiculo.getUsuarioIdUsando() != null && vehiculo.getUsuarioIdUsando().equals(loggedUser.getId())) {
            return;
        }

        //Si el vehiculo que va a empezar a usar, tiene un usuario ya asignado, le deja el log de uso con la fecha fin
        if(vehiculo.getUsuarioIdUsando() != null){
            updateFechaFinLogDeUso(id, vehiculo.getUsuarioIdUsando(), time);
        }

        // Hago que deje de usar los vehiculos asignados al usuario
        var vehiculosUsando = repository.findByusuarioIdUsando(loggedUser.getId());
        if (vehiculosUsando != null && !vehiculosUsando.isEmpty()) {
            for (Vehiculo v : vehiculosUsando) {
                v.setUsuarioIdUsando(null);
                //Actualizo la fecha fin de los logs de uso de sus vehiculos que estaba usando antes
                updateFechaFinLogDeUso(v.getId(), loggedUser.getId(), time);
                repository.save(v);
            }
        }


        // Asigno el vehiculo escaneado al usuario
        vehiculo.setUsuarioIdUsando(loggedUser.getId());

        repository.save(vehiculo);

        LogUsoVehiculo logUsoVehiculo = new LogUsoVehiculo();
        logUsoVehiculo.setFechaInicio(time != null ? time : LocalDateTime.now());
        logUsoVehiculo.setUsuarioId(loggedUser.getId());
        logUsoVehiculo.setVehiculoId(id);

        logUsoVehiculoRepository.save(logUsoVehiculo);
    }

    /**
     * 
     * @param id El id del vehiculo
     * @param time Puede ser null o no, es para indicar la fecha de fin, si es por sincronizacion de datos.
     */
    public void terminarUso(Integer id, LocalDateTime time) {
        // Obtenemos el vehiculo
        Vehiculo vehiculo = repository.getById(id);

        // Obtenemos el usuario logeado
        UsuarioView loggedUser = usuariosManager.getLoggeduser();

        if (vehiculo.getUsuarioIdUsando() != null && vehiculo.getUsuarioIdUsando().equals(loggedUser.getId())) {
            updateFechaFinLogDeUso(id, loggedUser.getId(), time);
            vehiculo.setUsuarioIdUsando(null);
            repository.save(vehiculo);
        } else {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El usuario actual no es el que esta usando este vehiculo.");
        }
    }

    private void updateFechaFinLogDeUso(Integer vehiculoId, Integer userId, LocalDateTime time){
        List<LogUsoVehiculo> logUsoVehiculo = logUsoVehiculoRepository.findByVehiculoIdAndUsuarioIdAndFechaFin(vehiculoId, userId, null);
        for (var log : logUsoVehiculo) {
            if(log != null && log.getFechaInicio() != null){
                log.setFechaFin(time != null ? time :LocalDateTime.now());
                logUsoVehiculoRepository.save(log);
            }
        }
    }

    public VehiculoView getCurrentVehiculo() {
        // Obtenemos el usuario logeado
        UsuarioView loggedUser = usuariosManager.getLoggeduser();
        var vehiculos = repository.findByusuarioIdUsando(loggedUser.getId());
        Vehiculo vehiculo;

        if (vehiculos != null && !vehiculos.isEmpty()) {
            vehiculo = repository.findByusuarioIdUsando(loggedUser.getId()).get(0);
        } else {
            // CAR-103
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay un vehiculo
            // actual");
            return null;
        }

        return armarVehiculoConPendientes(vehiculo, false);
    }

    @Transactional
    public void subirDocumentacion(int id, MultipartFile file, String tipo, String vencimiento) {
        // Buscamos el vehiculo
        Vehiculo v = repository.getById(id);

        if (!tipoDocumentoRepository.findAll().stream().anyMatch(x -> x.getNombre().equals(tipo))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ese tipo de documento");
        }

        // Busco los que esten activos
        var docsActivos = v.getDocumentoList().stream()
                .filter(x -> x.isActive() && x.getTipoDocumento().equals(tipo)).collect(Collectors.toList());

        // Los desactivo
        if (docsActivos.size() > 0) {
            for (Documento docActivo : docsActivos) {
                docActivo.setActive(false);

                documentoRepository.save(docActivo);
            }
        }

        // Seteamos el documento para guardar
        Documento doc = new Documento();
        try {
            doc.setData(file.getBytes());
            doc.setFormato(FilenameUtils.getExtension(file.getOriginalFilename()));
            doc.setContentType(file.getContentType());
            doc.setTipoDocumento(tipo);
            doc.setVehiculoId(id);
            doc.setActive(true);

            if (vencimiento != null && !vencimiento.isEmpty()) {
                doc.setVencimiento(
                        LocalDate.parse(vencimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())));
            }

            doc.setAvisoVencimiento(false);

            // Lo guardamos, obtenemos el id
            documentoRepository.save(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Documento getDocumentacionVehiculo(int id, String tipo) {
        // Buscamos el vehiculo
        Vehiculo v = repository.getById(id);

        // Comparamos el tipo de documento
        if (!tipoDocumentoRepository.findAll().stream().anyMatch(x -> x.getNombre().equals(tipo))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe ese tipo de documento");
        }

        List<Documento> listDoc = v.getDocumentoList();
        Optional<Documento> doc = listDoc.stream().filter(x -> x.getTipoDocumento().equals(tipo) && x.isActive())
                .findFirst();

        if (doc.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el documento asociado al vehiculo.");
        }

        return doc.get();
    }

    public List<DocumentoView> obtenerDocumentos(Integer id) {
        List<Documento> docs = documentoRepository.findByVehiculoIdAndActiveTrue(id);
        return docs.stream().map(DocumentoView::new).collect(Collectors.toList());
    }

    public List<EvaluacionView> obtenerFormularios(Integer id) {
        var evaluaciones = vehiculoEvaluacionRepository.findByVehiculoId(id).stream()
                .map(x -> new EvaluacionView(x.getEvaluacion())).collect(Collectors.toList());
        return evaluaciones;
    }

    public List<LogEvaluacionView> obtenerLogsFormularios(Integer id) {
        var evaluaciones = logEvaluacionRepository.findByVehiculoIdOrderByFechaDesc(id).stream()
                .map(x -> new LogEvaluacionView(x)).collect(Collectors.toList());
        return evaluaciones;
    }

    public List<LogUsoVehiculoView> obtenerLogsVehiculosUsados(Integer VehiculoId){
        List<LogUsoVehiculo> logs = logUsoVehiculoRepository.findAllByVehiculoId(VehiculoId);
        return logs.stream().map(LogUsoVehiculoView::new).collect(Collectors.toList());
    }

    // -------------------------------------------------------------------------------------------------------------------------------

    /**
     * Calcula la proxima fecha de la evaluacion
     * 
     * @param vehiculoEvaluacion
     * @return proxima fecha de la evaluacion
     */
    private LocalDate fechaProximoCheck(VehiculoEvaluacion vehiculoEvaluacion) {

        LocalDate hoy = LocalDate.now();

        LocalDate fechaPeriodo = vehiculoEvaluacion.getFechaInicio();

        int intervaloDias = vehiculoEvaluacion.getIntervaloDias();

        while (hoy.isAfter(fechaPeriodo) || hoy.isEqual(fechaPeriodo)) {
            fechaPeriodo = fechaPeriodo.plusDays(intervaloDias);
        }

        return fechaPeriodo;
    }

    private int getVencimientoOfEvaluacion(VehiculoEvaluacion vehiculoEvaluacion) {
        // Obtenemos el ultimo log de la evaluacion
        LogEvaluacion log = logEvaluacionRepository.getLastLogById(vehiculoEvaluacion.getEvaluacionId());

        // Si el ultimo log es null, es porque nunca se hizo una evaluacion
        if (log != null) {

            // Fecha del ultimo log
            LocalDateTime dateLog = log.getFecha();

            int intervaloDias = vehiculoEvaluacion.getIntervaloDias();

            // Fecha de la proxima vez que se deberia realizar la evaluacion
            LocalDateTime fechaProxima = fechaProximoCheck(vehiculoEvaluacion).atStartOfDay();

            LocalDateTime fechaAnterior = fechaProxima.minusDays(intervaloDias);

            int vencimiento = (int) LocalDateTime.now().toLocalDate().atStartOfDay().until(fechaProxima,
                    ChronoUnit.DAYS);

            if (dateLog.isBefore(fechaAnterior)) {
                return 0;
            }

            return vencimiento;
        } else {

            if (!vehiculoEvaluacion.getFechaInicio().isBefore(LocalDate.now())) {
                int vencimiento = (int) LocalDate.now().datesUntil(vehiculoEvaluacion.getFechaInicio()).count();
                return vencimiento;
            }

            return 0;
        }
    }

    private VehiculoView armarVehiculoConPendientes(Vehiculo v, boolean getFuturePendientes) {
        VehiculoView vehiculo = new VehiculoView(v, true);
        var listsEvaluacion = v.getVehiculoevaluacionList().stream().filter(x -> (!getFuturePendientes) ? (LocalDate.now().isAfter(x.getFechaInicio()) || (LocalDate.now().equals(x.getFechaInicio()))) : true )
                .map(x -> new EvaluacionLiteView(x.getEvaluacion(), getVencimientoOfEvaluacion(x),
                        x.getIntervaloDias()))
                .collect(Collectors.toList());

        vehiculo.setPendientes(listsEvaluacion);
        return vehiculo;
    }

}