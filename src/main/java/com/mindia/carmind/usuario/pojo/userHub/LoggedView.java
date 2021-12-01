
package com.mindia.carmind.usuario.pojo.userHub;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "CreateAt",
    "UpdateAt",
    "UserName",
    "Password",
    "FirstName",
    "LastName",
    "Roles",
    "DocumentType",
    "DocumentNumber"
})
@Generated("jsonschema2pojo")
public class LoggedView {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("CreateAt")
    private String createAt;
    @JsonProperty("UpdateAt")
    private String updateAt;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Roles")
    private List<String> roles = null;
    @JsonProperty("DocumentType")
    private Integer documentType;
    @JsonProperty("DocumentNumber")
    private String documentNumber;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoggedView() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param password
     * @param documentType
     * @param documentNumber
     * @param roles
     * @param updateAt
     * @param id
     * @param userName
     * @param createAt
     */
    public LoggedView(String id, String createAt, String updateAt, String userName, String password, String firstName, String lastName, List<String> roles, Integer documentType, String documentNumber) {
        super();
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("CreateAt")
    public String getCreateAt() {
        return createAt;
    }

    @JsonProperty("CreateAt")
    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @JsonProperty("UpdateAt")
    public String getUpdateAt() {
        return updateAt;
    }

    @JsonProperty("UpdateAt")
    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("UserName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("Password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("Roles")
    public List<String> getRoles() {
        return roles;
    }

    @JsonProperty("Roles")
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @JsonProperty("DocumentType")
    public Integer getDocumentType() {
        return documentType;
    }

    @JsonProperty("DocumentType")
    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    @JsonProperty("DocumentNumber")
    public String getDocumentNumber() {
        return documentNumber;
    }

    @JsonProperty("DocumentNumber")
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

}
