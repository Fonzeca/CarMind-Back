package com.mindia.carmind.user.manager;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindia.carmind.user.pojo.LoginView;
import com.mindia.carmind.user.pojo.TokenView;
import com.mindia.carmind.user.pojo.UserHubConfig;
import com.mindia.carmind.utils.Convertions;
import com.mindia.carmind.utils.exception.custom.UserHubException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class UserManager {

    @Autowired
    UserHubConfig userHubConfig;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public TokenView login(String username, String password) {
        //Armo el json a mandar
        LoginView loginView = new LoginView(username, password);

        //Armo el body
        RequestBody body = RequestBody.create(Convertions.toJson(loginView), MediaType.get("application/json; charset=utf-8"));

        String pathUserHub = "/login";

        //Armo el request para mandar a UserHub
        Request request = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub).post(body).build();

        //Llamo a la api
        try (Response response = client.newCall(request).execute()) {
            
            if(response.code() != 200){
                //Si el code no es 200, paso algo en UserHub
                throw new UserHubException(response.body().string());
            }else{
                return mapper.readValue(response.body().string(), TokenView.class);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }

    }

}
