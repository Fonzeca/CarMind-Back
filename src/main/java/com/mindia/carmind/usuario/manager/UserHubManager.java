package com.mindia.carmind.usuario.manager;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mindia.carmind.usuario.pojo.AltaPojo;
import com.mindia.carmind.usuario.pojo.ModificarPojo;
import com.mindia.carmind.usuario.pojo.userHub.LoginView;
import com.mindia.carmind.usuario.pojo.userHub.TokenView;
import com.mindia.carmind.usuario.pojo.userHub.UserHubConfig;
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
public class UserHubManager {

    @Autowired
    UserHubConfig userHubConfig;

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    private String tokenAdmin;

    protected TokenView login(String username, String password) {
        // Armo el json a mandar
        LoginView loginView = new LoginView(username, password);

        // Armo el body
        RequestBody body = RequestBody.create(Convertions.toJson(loginView),
                MediaType.get("application/json; charset=utf-8"));

        String pathUserHub = "/login";

        // Armo el request para mandar a UserHub
        Request request = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub).post(body).build();

        // Llamo a la api
        try (Response response = client.newCall(request).execute()) {

            if (response.code() != 200) {
                // Si el code no es 200, paso algo en UserHub
                throw new UserHubException(response.body().string());
            } else {
                return mapper.readValue(response.body().string(), TokenView.class);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    protected boolean altaUsuario(AltaPojo alta) {
        if (tokenAdmin == null || !validate()) {
            loginAsAdmin();
        }

        // Los roles que va a tener el usuario
        ArrayNode roles = mapper.createArrayNode();
        if (alta.getAdministrador()) {
            roles.add("admin_empresa");
        }

        roles.add("conductor");

        // Armo el json a mandar
        ObjectNode user = mapper.createObjectNode();
        user.put("userName", alta.getUsername());
        user.put("password", alta.getPassword());
        user.put("firstName", alta.getNombre());
        user.put("lastName", alta.getApellido());
        user.set("roles", roles);
        user.put("DocumentType", 1);
        user.put("DocumentNumber", alta.getDni());

        // Armo el body
        RequestBody body = RequestBody.create(Convertions.toJson(user),
                MediaType.get("application/json; charset=utf-8"));

        String pathUserHub = "/admin/user";

        // Armo el request para mandar a UserHub
        Request request = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub)
            .post(body)
            .addHeader("Authorization", "Bearer " + tokenAdmin)
            .build();

        // Llamo a la api
        try (Response response = client.newCall(request).execute()) {

            if (response.code() != 200) {
                // Si el code no es 200, paso algo en UserHub
                throw new UserHubException(response.body().string());
            } else {
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    protected boolean modifyUsuario(ModificarPojo pojo){
        if (tokenAdmin == null || !validate()) {
            loginAsAdmin();
        }

        // Los roles que va a tener el usuario
        ArrayNode roles = mapper.createArrayNode();
        if (pojo.getAdministrador()) {
            roles.add("admin_empresa");
        }

        roles.add("conductor");

        // Armo el json a mandar
        ObjectNode user = mapper.createObjectNode();
        user.put("userName", pojo.getUsername());
        user.put("password", pojo.getPassword());
        user.put("firstName", pojo.getNombre());
        user.put("lastName", pojo.getApellido());
        user.set("roles", roles);
        user.put("DocumentType", 1);
        user.put("DocumentNumber", pojo.getDni());

        // Armo el body
        RequestBody body = RequestBody.create(Convertions.toJson(user),
                MediaType.get("application/json; charset=utf-8"));

        String pathUserHub = "/admin/user";

        // Armo el request para mandar a UserHub
        Request request = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub)
            .put(body)
            .addHeader("Authorization", "Bearer " + tokenAdmin)
            .build();

        // Llamo a la api
        try (Response response = client.newCall(request).execute()) {

            if (response.code() != 200) {
                // Si el code no es 200, paso algo en UserHub
                throw new UserHubException(response.body().string());
            } else {
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
        
    }

    private boolean validate(){
        RequestBody body = RequestBody.create(null);

        String pathUserHub = "/validate";

        // Armo el request para mandar a UserHub
        Request request = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub).post(body).build();

        // Llamo a la api
        try (Response response = client.newCall(request).execute()) {

            if (response.code() != 200) {
                // Si el code no es 200, paso algo en UserHub
                return false;
            } else {
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }

    private void loginAsAdmin(){
        // Armo el json a mandar
        LoginView loginView = new LoginView(userHubConfig.getAdminUserName(), userHubConfig.getAdminPassword());

        // Armo el body
        RequestBody body = RequestBody.create(Convertions.toJson(loginView),
                MediaType.get("application/json; charset=utf-8"));

        String pathUserHub = "/login";

        // Armo el request para mandar a UserHub
        Request request = new Request.Builder().url(userHubConfig.getUrl() + pathUserHub).post(body).build();

        // Llamo a la api
        try (Response response = client.newCall(request).execute()) {

            if (response.code() != 200) {
                // Si el code no es 200, paso algo en UserHub
                throw new UserHubException(response.body().string());
            } else {
                TokenView token = mapper.readValue(response.body().string(), TokenView.class);
                tokenAdmin = token.getToken();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        }
    }
}
