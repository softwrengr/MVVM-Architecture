package com.sessionretrofitvidloginviewmodel.remote;

import android.arch.lifecycle.MutableLiveData;

import com.sessionretrofitvidloginviewmodel.models.dailyDataModel.DailyResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository newsRepository;
    private APIService newsApi;

    public static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    public NewsRepository(){
        newsApi = RetroClass.cteateService(APIService.class);
    }

    public MutableLiveData<DailyResponseModel> getNews(){
        MutableLiveData<DailyResponseModel> newsData = new MutableLiveData<>();
        newsApi.showDailyMessage().enqueue(new Callback<DailyResponseModel>() {
            @Override
            public void onResponse(Call<DailyResponseModel> call,
                                   Response<DailyResponseModel> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DailyResponseModel> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
