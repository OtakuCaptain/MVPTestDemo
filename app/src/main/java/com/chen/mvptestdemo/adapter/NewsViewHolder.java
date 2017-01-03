package com.chen.mvptestdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.mvptestdemo.R;

/**
 * Created by chen on 2017-01-03.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mTitle;
    public TextView mDescription;

    public NewsViewHolder(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.iv_small);
        mTitle = (TextView) itemView.findViewById(R.id.tv_title);
        mDescription = (TextView) itemView.findViewById(R.id.tv_description);
    }
}
