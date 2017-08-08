package com.example.shree.materialdesign8;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Vinod on 3/10/2017.
 */
public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/dpts/api/insert.php")
    public void insertUser(
            @Field("Name") String name,
            @Field("Mobile") String mobile,
            @Field("UserName") String username,
            @Field("Password") String password,
            @Field("Email") String email,
            @Field("Qulification") String qulification,
            @Field("Mci") String mci,
            @Field("Speciality") String speciality,
            @Field("SubSpeciality") String Subspeciality,
            Callback<Response> callback);
}
