package com.mindia.carmind.version.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Version;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "storeVersion",
})
@Generated("jsonschema2pojo")
public class LastVersionView {

    @JsonProperty("storeVersion")
    private String storeVersion;

    /**
     * No args constructor for use in serialization
     *
     */
    public LastVersionView() {
    }

    public LastVersionView(Version v) {
        storeVersion = v.getStoreVersion();
    }

    @JsonProperty("storeVersion")
    public String getStoreVersion() {
        return storeVersion;
    }

    @JsonProperty("storeVersion")
    public void setStoreVersion(String storeVersion) {
        this.storeVersion = storeVersion;
    }

}
