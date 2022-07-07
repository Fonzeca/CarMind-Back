package com.mindia.carmind.version.controller;

import java.util.List;

import com.mindia.carmind.version.manager.VersionManager;
import com.mindia.carmind.version.pojo.AltaPojo;
import com.mindia.carmind.version.pojo.LastVersionView;
import com.mindia.carmind.version.pojo.ModificarPojo;
import com.mindia.carmind.version.pojo.VersionView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionApi {

    @Autowired
    VersionManager manager;

    @GetMapping("/public/version")
    public List<VersionView> getAllVersiones() {
        return manager.getAllVersiones();
    }

    @GetMapping("/public/version/{version}/{platform}")
    public VersionView getVersion(@PathVariable String version, @PathVariable String platform) {
        return manager.obtenerVersionByVersion(version, platform);
    }

    @GetMapping("/public/lastVersion")
    public LastVersionView enviarTokenRecuperacionPassword(@RequestParam("platform") String platform ){
        return manager.getLastVersionByPlatform(platform);
    }

    @PostMapping("/public/version")
    public void altaVersion(@RequestBody AltaPojo pojo) {
        manager.altaVersion(pojo);
    }

    @PutMapping("/public/version")
    public void editarVersion(@RequestBody ModificarPojo pojo) {
        manager.modificarVersion(pojo);
    }

    @DeleteMapping("/public/version/{version}/{platform}")
    public void borrarVersion(@PathVariable String version, @PathVariable String platform) {
        manager.bajaVersion(version, platform);
    }

}
