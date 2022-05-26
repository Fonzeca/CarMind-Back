package com.mindia.carmind.empresa.manager;

import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.empresa.persistence.EmpresaRepository;
import com.mindia.carmind.empresa.pojo.AltaPojo;
import com.mindia.carmind.empresa.pojo.TipoPojo;
import com.mindia.carmind.empresa.pojo.TodosTiposPojo;
import com.mindia.carmind.entities.Empresa;
import com.mindia.carmind.pregunta.persistence.TipoPreguntaRepository;
import com.mindia.carmind.usuario.manager.UsuariosManager;
import com.mindia.carmind.vehiculo.persistence.TipoDocumentoRepository;
import com.mindia.carmind.vehiculo.persistence.TipoVehiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmpresaManager {

    @Autowired
    UsuariosManager usuariosManager;

    @Autowired
    EmpresaRepository repository;

    @Autowired
    TipoVehiculoRepository tipoVehiculoRepository;

    @Autowired
    TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    TipoPreguntaRepository tipoPreguntaRepository;

    @Transactional
    public void crearEmpresa(AltaPojo alta){

        if(repository.findByNombre(alta.getNombre()) != null ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Empresa duplicada");
        }

        Empresa empresa = new Empresa();
        empresa.setNombre(alta.getNombre());
        empresa.setUnidadDistancia(alta.getUnidadDistancia());

        repository.save(empresa);

        usuariosManager.altaUsuario(alta.getUsuarioAdmin(), empresa.getId());

    }

    public TodosTiposPojo getAllTipos(){
        TodosTiposPojo pojo = new TodosTiposPojo();

        List<String> tiposVehiculo = tipoVehiculoRepository.findAll().stream().map(x -> x.getNombre()).collect(Collectors.toList());

        List<String> tiposDocumento = tipoDocumentoRepository.findAll().stream().map(x -> x.getNombre()).collect(Collectors.toList());

        List<TipoPojo> tiposPregunta = getTiposPregunta();


        pojo.setTipoDocumento(tiposDocumento);
        pojo.setTipoVehiculo(tiposVehiculo);
        pojo.setTipoPregunta(tiposPregunta);

        return pojo;
    }

    public List<TipoPojo> getTiposPregunta(){
        return tipoPreguntaRepository.findAll().stream().map(x -> new TipoPojo(x.getCodigo(), x.getNombre(), x.getInfo())).collect(Collectors.toList());
    }
}
