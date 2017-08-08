package com.example.shree.materialdesign8;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vinod on 3/21/2017.
 */
public class DataObject1 {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Pincode")
    @Expose
    private String pincode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
