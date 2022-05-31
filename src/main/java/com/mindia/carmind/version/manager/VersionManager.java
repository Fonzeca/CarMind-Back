package com.mindia.carmind.version.manager;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.mindia.carmind.entities.Version;
import com.mindia.carmind.entities.interfaces.IVersion;
import com.mindia.carmind.version.persistence.VersionesRepository;
import com.mindia.carmind.version.pojo.AltaPojo;
import com.mindia.carmind.version.pojo.ModificarPojo;
import com.mindia.carmind.version.pojo.VersionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VersionManager implements IVersion {

    @Autowired
    VersionesRepository repository;


    public void altaVersion(AltaPojo pojo) {

        pojo.validate();

        Version version = new Version();
       
        version.setStoreVersion(pojo.getStoreVersion());
        version.setStoreReleaseNotes(pojo.getStoreReleaseNotes());
        version.setStoreType(pojo.getStoreType());

        repository.save(version);
    }

    public void modificarVersion(ModificarPojo pojo) {

        pojo.validate();

        Version version = repository.findByStoreVersion(pojo.getStoreVersion());

        if (version == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Version no encontrada");
        }

        version.setStoreVersion(pojo.getStoreVersion());
        version.setStoreReleaseNotes(pojo.getStoreReleaseNotes());
        version.setStoreType(pojo.getStoreType());

        repository.save(version);
    }

    public void bajaVersion(String version) {
        try {
            Version v = repository.findByStoreVersion(version);
            repository.delete(v);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("No se encontró la entidad Version " + version);
        }
    }

    public VersionView obtenerVersionByVersion(String version) {
        Version v = repository.findByStoreVersion(version);
        VersionView versionView = new VersionView(v);
        return versionView;
    }

    @Override
    public List<VersionView> getAllVersiones() {
        List<Version> v = repository.findAll();
        return v.stream().map(VersionView::new).collect(Collectors.toList());
    }

}