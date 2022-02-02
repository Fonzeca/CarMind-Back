
package com.mindia.carmind.usuario.pojo;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "token",
    "newPassword"
})
@Generated("jsonschema2pojo")
public class RecuperacionPojo {

    @JsonProperty("email")
    private String email;
    @JsonProperty("token")
    private String token;
    @JsonProperty("newPassword")
    private String newPassword;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RecuperacionPojo() {
    }

    /**
     * 
     * @param newPassword
     * @param email
     * @param token
     */
    public RecuperacionPojo(String email, String token, String newPassword) {
        super();
        this.email = email;
        this.token = token;
        this.newPassword = newPassword;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("newPassword")
    public String getNewPassword() {
        return newPassword;
    }

    @JsonProperty("newPassword")
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
