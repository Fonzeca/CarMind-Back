package com.mindia.carmind.user.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"token"
})
@Generated("jsonschema2pojo")
public class TokenView {

@JsonProperty("token")
private String token;

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

}