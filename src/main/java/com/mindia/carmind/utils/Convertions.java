package com.mindia.carmind.utils;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Convertions {

    public Integer toInt(String id) {
        return Integer.parseInt(id);
    }

    public static String toJson(Object o){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> fromJson(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
