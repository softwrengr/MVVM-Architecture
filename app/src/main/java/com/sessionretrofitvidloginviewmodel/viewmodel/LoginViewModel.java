package com.sessionretrofitvidloginviewmodel.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.Toast;

import com.sessionretrofitvidloginviewmodel.models.loginDataModels.LoginResponseModel;
import com.sessionretrofitvidloginviewmodel.remote.APIService;
import com.sessionretrofitvidloginviewmodel.remote.RetroClass;
import com.sessionretrofitvidloginviewmodel.utilities.GeneralUtills;
import com.sessionretrofitvidloginviewmodel.view.activities.ContainerActivity;
import com.sessionretrofitvidloginviewmodel.view.fragments.HomeFragment;

import org.json.JSONObject;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends Observable {

    private Context context;
    public ObservableInt progressBar;
    public final ObservableField<String> username = new ObservableField<>("");
    public final ObservableField<String> userpass = new ObservableField<>("");

    public LoginViewModel(Context context) {
        this.context = context;
        progressBar = new ObservableInt(View.GONE);
    }


    public void sendLoginRequest(String name, String pass) {
        progressBar.set(View.VISIBLE);

        APIService apiService = RetroClass.getAPIService();
        Call<LoginResponseModel> loginresponse = apiService.userLogin(name, pass);
        loginresponse.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {

                progressBar.set(View.GONE);
                if (response.body() == null) {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        showToast("invalid");
                    } catch (Exception e) {
                        showToast("error");
                    }
                } else if(response.body().getSuccess()) {
                    context.startActivity(new Intent(context, ContainerActivity.class));
                    showToast("" + response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                progressBar.set(View.GONE);
                showToast("" + t.getMessage());

            }
        });


    }


   private void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

}
