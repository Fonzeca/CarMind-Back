package com.mindia.carmind.empresa.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "value"
})
@Generated("jsonschema2pojo")
public class TipoPojo {

    @JsonProperty("id")
    private String id;
    @JsonProperty("value")
    private String value;

    /**
     * No args constructor for use in serialization
     *
     */
    public TipoPojo() {
    }

    /**
     *
     * @param id
     * @param value
     */
    public TipoPojo(String id, String value) {
        super();
        this.id = id;
        this.value = value;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

}