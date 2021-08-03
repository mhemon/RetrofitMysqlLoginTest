package com.xploreict.retrofitmysqllogintest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {
    @FormUrlEncoded
    @POST("login.php")
    Call<responsemodel> verifyuser(
            @Field("username") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user_reg.php")
    Call<reg_model> reguser(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email
    );

    @GET("json_user_fetch.php")
    Call<List<fetchdatamodel>> getdata();
}

