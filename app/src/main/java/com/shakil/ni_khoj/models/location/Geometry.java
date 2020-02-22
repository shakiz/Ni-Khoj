package com.shakil.ni_khoj.models.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "location"
})
public class Geometry {

    @JsonProperty("location")
    private LocationMeta location;

    @JsonProperty("location")
    public LocationMeta getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(LocationMeta location) {
        this.location = location;
    }
}
