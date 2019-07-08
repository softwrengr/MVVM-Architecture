package com.sessionretrofitvidloginviewmodel.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sessionretrofitvidloginviewmodel.R;
import com.sessionretrofitvidloginviewmodel.databinding.ActivityMainBinding;
import com.sessionretrofitvidloginviewmodel.presenter.Presenter;
import com.sessionretrofitvidloginviewmodel.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity{

    private LoginViewModel loginViewModel;
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loginViewModel = new LoginViewModel(this);
        activityMainBinding.setLoginview(loginViewModel);

        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void loginData() {
                final String name = activityMainBinding.username.getText().toString();
                final String pass = activityMainBinding.userpass.getText().toString();
                loginViewModel.sendLoginRequest(name, pass);

            }
        });

    }

}
