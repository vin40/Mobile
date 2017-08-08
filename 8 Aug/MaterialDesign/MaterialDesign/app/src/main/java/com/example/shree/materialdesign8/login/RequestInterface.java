package com.example.shree.materialdesign8.login;



import com.example.shree.materialdesign8.login.models.ServerRequest;
import com.example.shree.materialdesign8.login.models.ServerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestInterface {

    @POST("dpts/login/")
    Call<ServerResponse> operation(@Body ServerRequest request);

}
