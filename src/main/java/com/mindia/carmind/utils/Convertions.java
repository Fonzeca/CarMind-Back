package com.mindia.carmind.utils;

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class Convertions {

    public static String toJson(Object o) {
        ObjectMapper mapper = JsonMapper.builder()
     .findAndAddModules()
     .build();
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static boolean hasRole(String role) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Collection<? extends GrantedAuthority> userRoles = auth.getAuthorities();
            return userRoles.stream().anyMatch(x -> x.getAuthority().equals(role));
        }else{
            return false;
        }
    }
}
