package com.mindia.carmind.notificacion.pojo;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "imei",
        "zone_name",
        "zone_id",
        "event_type",
        "vehiculo_id",
        "vehiculo_name",
        "emails"
})
@Generated("jsonschema2pojo")
public class ZoneNotification {

    @JsonProperty("imei")
    private String imei;
    @JsonProperty("zone_name")
    private String zoneName;
    @JsonProperty("zone_id")
    private Integer zoneId;
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("vehiculo_id")
    private Integer vehiculoId;
    @JsonProperty("vehiculo_name")
    private String vehiculoName;
    @JsonProperty("emails")
    private List<String> emails = null;

    @JsonProperty("imei")
    public String getImei() {
        return imei;
    }

    @JsonProperty("imei")
    public void setImei(String imei) {
        this.imei = imei;
    }

    @JsonProperty("zone_name")
    public String getZoneName() {
        return zoneName;
    }

    @JsonProperty("zone_name")
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @JsonProperty("zone_id")
    public Integer getZoneId() {
        return zoneId;
    }

    @JsonProperty("zone_id")
    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    @JsonProperty("event_type")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("event_type")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("vehiculo_id")
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    @JsonProperty("vehiculo_id")
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    @JsonProperty("vehiculo_name")
    public String getVehiculoName() {
        return vehiculoName;
    }

    @JsonProperty("vehiculo_name")
    public void setVehiculoName(String vehiculoName) {
        this.vehiculoName = vehiculoName;
    }

    @JsonProperty("emails")
    public List<String> getEmails() {
        return emails;
    }

    @JsonProperty("emails")
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ZoneNotification.class.getName()).append('@')
                .append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("imei");
        sb.append('=');
        sb.append(((this.imei == null) ? "<null>" : this.imei));
        sb.append(',');
        sb.append("zoneName");
        sb.append('=');
        sb.append(((this.zoneName == null) ? "<null>" : this.zoneName));
        sb.append(',');
        sb.append("zoneId");
        sb.append('=');
        sb.append(((this.zoneId == null) ? "<null>" : this.zoneId));
        sb.append(',');
        sb.append("eventType");
        sb.append('=');
        sb.append(((this.eventType == null) ? "<null>" : this.eventType));
        sb.append(',');
        sb.append("vehiculoId");
        sb.append('=');
        sb.append(((this.vehiculoId == null) ? "<null>" : this.vehiculoId));
        sb.append(',');
        sb.append("vehiculoName");
        sb.append('=');
        sb.append(((this.vehiculoName == null) ? "<null>" : this.vehiculoName));
        sb.append(',');
        sb.append("emails");
        sb.append('=');
        sb.append(((this.emails == null) ? "<null>" : this.emails));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}