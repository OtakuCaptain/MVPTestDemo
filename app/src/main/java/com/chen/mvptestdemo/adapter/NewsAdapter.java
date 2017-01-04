package com.chen.mvptestdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.mvptestdemo.R;
import com.chen.mvptestdemo.model.NewsModel;
import com.chen.mvptestdemo.utils.ImageViewLoaderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {


    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<NewsModel> mData;

    public NewsAdapter(Context context, ArrayList<NewsModel> data) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.news_item_recview, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {


        NewsModel newsModel = mData.get(position);
//        holder.mTitle.setText(newsModel.getName());
//        holder.mDescription.setText(newsModel.getDescription());
//        ImageViewLoaderUtils.display(mContext, holder.mImageView, newsModel.getPicsmall());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
