package com.mindia.carmind.empresa.manager;

import java.util.List;
import java.util.stream.Collectors;

import com.mindia.carmind.empresa.persistence.EmpresaRepository;
import com.mindia.carmind.empresa.pojo.AltaPojo;
import com.mindia.carmind.empresa.pojo.TiposPojo;
import com.mindia.carmind.entities.Empresa;
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

    public TiposPojo getAllTipos(){
        TiposPojo pojo = new TiposPojo();

        List<String> tiposVehiculo = tipoVehiculoRepository.findAll().stream().map(x -> x.getNombre()).collect(Collectors.toList());

        List<String> tiposDocumento = tipoDocumentoRepository.findAll().stream().map(x -> x.getNombre()).collect(Collectors.toList());

        pojo.setTipoDocumento(tiposDocumento);
        pojo.setTipoVehiculo(tiposVehiculo);

        return pojo;
    }
}
