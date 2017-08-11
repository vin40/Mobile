package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP-PC on 6/12/2017.
 */
public class Ayush {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Specility")
    @Expose
    private String specility;
    @SerializedName("SubSpecility")
    @Expose
    private String subSpecility;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecility() {
        return specility;
    }

    public void setSpecility(String specility) {
        this.specility = specility;
    }

    public String getSubSpecility() {
        return subSpecility;
    }

    public void setSubSpecility(String subSpecility) {
        this.subSpecility = subSpecility;
    }
}
