package com.sessionretrofitvidloginviewmodel.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sessionretrofitvidloginviewmodel.R;
import com.sessionretrofitvidloginviewmodel.adapters.NewsAdapter;
import com.sessionretrofitvidloginviewmodel.models.dailyDataModel.DailyDetailModel;
import com.sessionretrofitvidloginviewmodel.viewmodel.DailyViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    View view;
    ArrayList<DailyDetailModel> articleArrayList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    DailyViewModel newsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHeadline = view.findViewById(R.id.rvNews);


        newsViewModel = ViewModelProviders.of(getActivity()).get(DailyViewModel.class);
        newsViewModel.init();
        newsViewModel.getDailyUpdates().observe(getActivity(), newsResponse -> {
            List<DailyDetailModel> newsArticles = newsResponse.getData();
            articleArrayList.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter(getActivity(), articleArrayList);
            rvHeadline.setLayoutManager(new LinearLayoutManager(getActivity()));
            rvHeadline.setAdapter(newsAdapter);
            rvHeadline.setItemAnimator(new DefaultItemAnimator());
            rvHeadline.setNestedScrollingEnabled(true);
        } else {
            newsAdapter.notifyDataSetChanged();
        }
    }

}
