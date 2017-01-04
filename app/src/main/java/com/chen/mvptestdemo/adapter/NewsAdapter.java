package com.chen.mvptestdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.mvptestdemo.R;
import com.chen.mvptestdemo.model.NewsModel;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {


    private LayoutInflater mInflater;
    private Context mContext;
    private List<NewsModel> mData;

    public NewsAdapter(Context context, List<NewsModel> data) {
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

    class NewsViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTitle;
        public TextView mDescription;

        NewsViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_small);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mDescription = (TextView) itemView.findViewById(R.id.tv_description);
        }
    }
    public interface  OnItemClickListener {
        void onItemClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
//        this.mOnItemClickListener=onItemClickListener;
    }
}
