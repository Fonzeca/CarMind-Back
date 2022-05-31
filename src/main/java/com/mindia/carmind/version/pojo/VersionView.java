package com.mindia.carmind.version.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mindia.carmind.entities.Version;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "storeVersion",
        "storeReleaseNotes",
        "storeType",
})
@Generated("jsonschema2pojo")
public class VersionView {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("storeVersion")
    private String storeVersion;
    @JsonProperty("storeReleaseNotes")
    private String storeReleaseNotes;
    @JsonProperty("storeType")
    private String storeType;

    /**
     * No args constructor for use in serialization
     *
     */
    public VersionView() {
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("storeVersion")
    public String getStoreVersion() {
        return storeVersion;
    }

    @JsonProperty("storeVersion")
    public void setStoreVersion(String storeVersion) {
        this.storeVersion = storeVersion;
    }

    @JsonProperty("storeReleaseNotes")
    public String getStoreReleaseNotes() {
        return storeReleaseNotes;
    }

    @JsonProperty("storeReleaseNotes")
    public void setStoreReleaseNotes(String storeReleaseNotes) {
        this.storeReleaseNotes = storeReleaseNotes;
    }

    @JsonProperty("storeType")
    public String getStoreType() {
        return storeType;
    }

    @JsonProperty("storeType")
    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public VersionView(Version v) {
        id = v.getId();
        storeVersion = v.getStoreVersion();
        storeReleaseNotes = v.getStoreReleaseNotes();
        storeType = v.getStoreType();
    }

}
