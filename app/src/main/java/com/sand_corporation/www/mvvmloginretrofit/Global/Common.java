package com.sand_corporation.www.mvvmloginretrofit.Global;

import com.sand_corporation.www.mvvmloginretrofit.Remote.APIService;
import com.sand_corporation.www.mvvmloginretrofit.Remote.RetrofitClient;

public class Common {
    public static final String BASE_URL = "http://192.168.99.106:3000/";

    public static APIService getRetrofitClient(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
