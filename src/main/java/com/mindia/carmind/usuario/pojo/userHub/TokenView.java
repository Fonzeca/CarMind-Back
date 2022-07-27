package com.mindia.carmind.usuario.pojo.userHub;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "mustChangePassword"
})
@Generated("jsonschema2pojo")
public class TokenView {

    @JsonProperty("token")
    private String token;
    @JsonProperty("mustChangePassword")
    private boolean mustChangePassword;

    /**
     * No args constructor for use in serialization
     *
     */
    public TokenView() {
    }

    /**
     *
     * @param token
     */
    public TokenView(String token) {
        super();
        this.token = token;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }


    @JsonProperty("mustChangePassword")
    public boolean getMustChangePassword() {
        return this.mustChangePassword;
    }

    @JsonProperty("mustChangePassword")
    public void setMustChangePassword(boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }


}