package com.sand_corporation.www.mvvmloginretrofit;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sand_corporation.www.mvvmloginretrofit.Presenter.Presenter;
import com.sand_corporation.www.mvvmloginretrofit.ViewModel.LogInViewModel;
import com.sand_corporation.www.mvvmloginretrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding mainBinding;
    private LogInViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewModel = new LogInViewModel(this);
        mainBinding.setLogInView(mViewModel);
        mainBinding.setPresenter(new Presenter() {
            @Override
            public void sendLogInData() {
                String userName = mainBinding.getLogInView().userName.get();
                String userPassword = mainBinding.getLogInView().userPassword.get();
                Log.i(TAG,"userName: " + userName + "\n" +
                        "userPassword: " + userPassword);

                mViewModel.sendLogInDataToRemote(userName,userPassword);
            }
        });
    }
}
