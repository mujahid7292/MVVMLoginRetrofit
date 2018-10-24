package com.sand_corporation.www.mvvmloginretrofit.Remote;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sand_corporation.www.mvvmloginretrofit.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    private static OkHttpClient.Builder getOKHttpBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG){
            builder.addInterceptor(interceptor);
        }
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder newRequest = request.newBuilder()
                        .header("Authorization", Credentials.basic("mujahid","123456"));
                return chain.proceed(newRequest.build());
            }
        });
        return builder;
    }

    public static Retrofit getClient(String BASE_URL){

        Gson gson = new GsonBuilder().setLenient().create();
        //There is some problem in getting String data from server
        //So we are setting GsonBuilder().setLenient().
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOKHttpBuilder().build())
                .build();
        return retrofit;
    }

}
