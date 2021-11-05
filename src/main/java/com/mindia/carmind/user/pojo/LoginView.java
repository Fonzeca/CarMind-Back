
package com.mindia.carmind.user.pojo;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userName",
    "password"
})
@Generated("jsonschema2pojo")
public class LoginView {

    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginView() {
    }

    /**
     * 
     * @param password
     * @param userName
     */
    public LoginView(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

}
