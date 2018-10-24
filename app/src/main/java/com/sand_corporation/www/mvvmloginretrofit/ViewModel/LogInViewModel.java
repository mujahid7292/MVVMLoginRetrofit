package com.sand_corporation.www.mvvmloginretrofit.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;

import com.sand_corporation.www.mvvmloginretrofit.Global.Common;
import com.sand_corporation.www.mvvmloginretrofit.Remote.APIService;

import java.util.Observable;

public class LogInViewModel extends Observable {

    private static final String TAG = "LogInViewModel";
    private Context mContext;
    private APIService mService;
    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> userPassword = new ObservableField<>("");

    public LogInViewModel(Context mContext) {
        this.mContext = mContext;
        mService = Common.getRetrofitClient();
    }

    public void sendLogInDataToRemote(String userName,String userPassword){
        Log.i(TAG,"userName: " + userName + "\n" +
        "userPassword: " + userPassword);
        mService.sendLogInAuth(userName,userPassword);

    }
}
