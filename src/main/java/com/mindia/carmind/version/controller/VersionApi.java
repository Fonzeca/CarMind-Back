package com.mindia.carmind.version.controller;

import java.util.List;

import com.mindia.carmind.version.manager.VersionManager;
import com.mindia.carmind.version.pojo.AltaPojo;
import com.mindia.carmind.version.pojo.ModificarPojo;
import com.mindia.carmind.version.pojo.VersionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionApi {

    @Autowired
    VersionManager manager;

    @GetMapping("/version")
    public List<VersionView> getAllVersiones() {
        return manager.getAllVersiones();
    }

    @GetMapping("/version/{version}")
    public VersionView getVersion(@PathVariable String version) {
        return manager.obtenerVersionByVersion(version);
    }

    @PostMapping("/version")
    public void altaVersion(@RequestBody AltaPojo pojo) {
        manager.altaVersion(pojo);
    }

    @PutMapping("/version")
    public void editarVersion(@RequestBody ModificarPojo pojo) {
        manager.modificarVersion(pojo);
    }

    @DeleteMapping("/version/{version}")
    public void borrarVersion(@PathVariable String version) {
        manager.bajaVersion(version);
    }

}
