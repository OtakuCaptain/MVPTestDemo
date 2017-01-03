package com.chen.mvptestdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.mvptestdemo.R;
import com.chen.mvptestdemo.adapter.NewsAdapter;
import com.chen.mvptestdemo.db.NewsBean;
import com.chen.mvptestdemo.view.NewsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */
public class NewsFragment extends Fragment implements NewsView {

    private RecyclerView mRecyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsBean> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.news_fragment, null);
        initData();

        initView(view);

        return view;
    }

    private void initData() {
        mData = new ArrayList<>();
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(getActivity(), mData);
        mRecyclerView.setAdapter(newsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public void addData(List<NewsBean> mList) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showLoadFail() {

    }
}
