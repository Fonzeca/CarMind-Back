package com.mindia.carmind.user.controller;

import com.mindia.carmind.user.manager.UserManager;
import com.mindia.carmind.user.pojo.TokenView;
import com.mindia.carmind.user.pojo.UserHubConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    
    @Autowired
    UserHubConfig userHubConfig;

    @Autowired
    UserManager manager;

    @PostMapping("/login")
    public TokenView getVehiculo(@RequestParam("username") String userName, @RequestParam("password") String password) {
        return manager.login(userName, password);
    }

}
