/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                      -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

//Responsible for handling the Countries logic and communication with the network and database layers.
public class Locations implements Serializable {

    @SerializedName("locations")
    @Expose
    private List<Location> locations;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public static class Location implements Serializable{

        @SerializedName("idLocation")
        @Expose
        private String idLocation;
        @SerializedName("strLocation")
        @Expose
        private String strLocation;
        @SerializedName("strLocationThumb")
        @Expose
        private String strLocationThumb;
        @SerializedName("strLocationDescription")
        @Expose
        private String strLocationDescription;

        public String getIdLocation() {
            return idLocation;
        }

        public void setIdLocation(String idLocation) {
            this.idLocation = idLocation;
        }

        public String getStrLocation() {
            return strLocation;
        }

        public void setStrLocation(String strLocation) {
            this.strLocation = strLocation;
        }

        public String getStrLocationThumb() {
            return strLocationThumb;
        }

        public void setStrLocationThumb(String strLocationThumb) {
            this.strLocationThumb = strLocationThumb;
        }

        public String getStrLocationDescription() {
            return strLocationDescription;
        }

        public void setStrLocationDescription(String strLocationDescription) {
            this.strLocationDescription = strLocationDescription;
        }
    }
}