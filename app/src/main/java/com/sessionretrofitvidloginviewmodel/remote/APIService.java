package com.sessionretrofitvidloginviewmodel.remote;

import com.sessionretrofitvidloginviewmodel.models.loginDataModels.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lenovo on 3/31/2018.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponseModel> userlogincall(@Field("email") String username,
                                           @Field("password") String userpass,
                                           @Field("latitude") String lat,
                                           @Field("longitude") String lng,
                                           @Field("deviceToken") String token);





}
