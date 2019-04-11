package com.sessionretrofitvidloginviewmodel.viewmodel;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.sessionretrofitvidloginviewmodel.ContainerActivity;
import com.sessionretrofitvidloginviewmodel.models.loginDataModels.LoginResponseModel;
import com.sessionretrofitvidloginviewmodel.remote.APIService;
import com.sessionretrofitvidloginviewmodel.remote.RetroClass;
import com.sessionretrofitvidloginviewmodel.utilities.GeneralUtills;
import com.sessionretrofitvidloginviewmodel.view.HomeFragment;

import org.json.JSONObject;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 3/31/2018.
 */

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
        Call<LoginResponseModel> loginresponse = apiService.userlogincall(name, pass, "30000", "35000", "eTl3tRGOkWg:APA91bGh3l9XRPBWfOUzxXDLVKe-9LjDcYBDB0sRNpQxjKMsf4XnZEjdJI2v6t1hVEBHNFaw3vItgDteo80wyQZN6gKSHOJYhMdP-rkqMB78tL_x9gP70srGBEwt6kWOQFKi9A7_kdEH");
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
                } else {
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


    void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        context.startActivity(new Intent(context, ContainerActivity.class));

    }

}
