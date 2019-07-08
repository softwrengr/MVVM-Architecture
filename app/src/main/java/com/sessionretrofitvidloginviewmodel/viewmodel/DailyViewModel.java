package com.sessionretrofitvidloginviewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.sessionretrofitvidloginviewmodel.models.dailyDataModel.DailyResponseModel;
import com.sessionretrofitvidloginviewmodel.remote.NewsRepository;

public class DailyViewModel extends ViewModel {

    private MutableLiveData<DailyResponseModel> mutableLiveData;
    private NewsRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews();

    }

    public LiveData<DailyResponseModel> getDailyUpdates() {
        return mutableLiveData;
    }
}
