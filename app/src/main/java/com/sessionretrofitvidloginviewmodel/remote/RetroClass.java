package com.sessionretrofitvidloginviewmodel.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 3/31/2018.
 */

public class RetroClass {

    private static final String BASE_URL = "http://api.divergense.com/myface/api/";
    private static Retrofit getRetrofitInstance()
    {
        Gson gson =     new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static APIService getAPIService()
    {
        return getRetrofitInstance().create(APIService.class);
    }


}
