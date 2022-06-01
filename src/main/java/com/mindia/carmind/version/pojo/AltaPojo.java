package com.mindia.carmind.version.pojo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@JsonPropertyOrder({ "storeVersion", "storeReleaseNotes", "storeType"})
@Generated("jsonschema2pojo")
public class AltaPojo {

    @JsonProperty("storeVersion")
    private String storeVersion;
    @JsonProperty("storeReleaseNotes")
    private String storeReleaseNotes;
    @JsonProperty("storeType")
    private String storeType;

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

    public boolean validate() {

        
        if(this.storeVersion == null || this.storeVersion.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Versión vacía");
        }
        
        
        if(this.storeType == null || this.storeType.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de tienda vacío");
        }
        
        this.storeVersion = this.storeVersion.trim();
        this.storeType = this.storeType.trim();
        
        if(this.storeType.equals("App Store")  || this.storeType.equals("Play Store") ){
            return true;
        }
        
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tipo de tienda solo admite dos valores: App Store o Play Store");

    }

}
