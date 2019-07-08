package com.sessionretrofitvidloginviewmodel.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.sessionretrofitvidloginviewmodel.R;
import com.sessionretrofitvidloginviewmodel.models.dailyDataModel.DailyDetailModel;
import com.sessionretrofitvidloginviewmodel.models.dailyDataModel.DailyResponseModel;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<DailyDetailModel> articles;

    public NewsAdapter(Context context, ArrayList<DailyDetailModel> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        holder.tvName.setText(articles.get(position).getText().toString());
        holder.tvDesCription.setText(articles.get(position).getTime().toString());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDesCription;
        ImageView ivNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDesCription = itemView.findViewById(R.id.tvDesCription);
            ivNews = itemView.findViewById(R.id.ivNews);

        }
    }
}
