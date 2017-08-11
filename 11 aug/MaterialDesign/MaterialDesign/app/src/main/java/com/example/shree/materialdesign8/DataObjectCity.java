package com.example.shree.materialdesign8;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vinod on 3/21/2017.
 */
public class DataObjectCity {
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("is_enabled")
    @Expose
    private String isEnabled;
    @SerializedName("citylist")
    @Expose
    private List<DataObjectCity> citylist = null;
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public List<DataObjectCity> getCitylist() {
        return citylist;
    }

    public void setCitylist(List<DataObjectCity> citylist) {
        this.citylist = citylist;
    }

}
