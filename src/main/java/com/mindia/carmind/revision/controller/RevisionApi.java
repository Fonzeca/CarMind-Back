package com.mindia.carmind.revision.controller;

import com.mindia.carmind.revision.manager.RevisionManager;
import com.mindia.carmind.revision.pojo.AltaRevision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevisionApi {

    @Autowired
    RevisionManager manager;

    @PostMapping("/revision")
    public void insertRevision(@RequestBody AltaRevision alta){
        manager.altaRevision(alta);
    }
}
