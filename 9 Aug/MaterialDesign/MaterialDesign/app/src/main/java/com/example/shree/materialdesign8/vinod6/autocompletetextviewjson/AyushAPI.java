package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by HP-PC on 6/12/2017.
 */
public interface AyushAPI {

    @GET("/onclickfilter/MobileData.php")
    public void getAllAysh(Callback<List<Ayush>> response);
}
