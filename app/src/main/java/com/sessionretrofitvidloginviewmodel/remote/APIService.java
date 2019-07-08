package com.sessionretrofitvidloginviewmodel.remote;

import com.sessionretrofitvidloginviewmodel.models.dailyDataModel.DailyResponseModel;
import com.sessionretrofitvidloginviewmodel.models.loginDataModels.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by lenovo on 3/31/2018.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("signup/login")
    Call<LoginResponseModel> userLogin(@Field("email") String email,
                                       @Field("password") String password);
    @GET("App/morningPerspective")
    Call<DailyResponseModel> showDailyMessage();





}
