package com.example.shree.materialdesign8;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Vinod on 3/10/2017.
 */
public interface RegisterAPI7 {
    @FormUrlEncoded
    @POST("/dpts/api/insert1.php")
    public void insertUser(
            @Field("FirstName") String FirstName,
            @Field("LastName") String LastName,
            @Field("City") String City,
            @Field("mci") String mci,
            @Field("mobile") String mobile,
            @Field("doctortype") String alopathic,
            @Field("specilty") String specility,
            @Field("subspecilty") String subspecility,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("repassword") String repassword,
            Callback<Response> callback);
}
