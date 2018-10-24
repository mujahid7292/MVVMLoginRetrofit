package com.sand_corporation.www.mvvmloginretrofit.Remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/LogInAuth.js")
    Call<String> sendLogInAuth(
            @Field("userName") String userName,
            @Field("userPassword") String userPassword
    );
}
