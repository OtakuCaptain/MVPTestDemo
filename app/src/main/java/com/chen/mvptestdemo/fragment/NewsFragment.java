package com.chen.mvptestdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chen.mvptestdemo.R;
import com.chen.mvptestdemo.adapter.NewsAdapter;
import com.chen.mvptestdemo.bean.NewsDetail;
import com.chen.mvptestdemo.presenter.NewsPresenter;
import com.chen.mvptestdemo.presenter.NewsPresenterImpl;
import com.chen.mvptestdemo.view.NewsView;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements NewsView, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private NewsAdapter newsAdapter;
    private ArrayList<NewsDetail> mData;
    private NewsPresenter newsPresenter;
    private SwipeRefreshLayout mSwipeRefreshWidget;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsPresenter = new NewsPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, null);
        initView(view);
        onRefresh();
        return view;
    }
    private void initView(View view) {
        mSwipeRefreshWidget= (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        mSwipeRefreshWidget.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark, R.color.colorAccent,
                R.color.colorAccent);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(getActivity());
        mRecyclerView.setAdapter(newsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void addData(List<NewsDetail> mList) {
        if(null==mData){
            mData = new ArrayList<>();
        }
        mData.addAll(mList);
        newsAdapter.updateUi(mData);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public void showLoadFail() {

    }



    @Override
    public void onRefresh() {
        System.out.println("刷新==============");
        if(mData!=null){
            mData.clear();
        }
        newsPresenter.getData();
    }
}
