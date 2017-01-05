package com.chen.mvptestdemo.presenter;

import com.chen.mvptestdemo.bean.NewsDetail;
import com.chen.mvptestdemo.model.NewsModel;
import com.chen.mvptestdemo.model.NewsModelImpl;
import com.chen.mvptestdemo.view.NewsView;

import java.util.ArrayList;

public class NewsPresenterImpl implements NewsPresenter, NewsModelImpl.OnLoadNewsDataListener {

    private NewsView mNewView;
    private NewsModel newsModel;


    public NewsPresenterImpl(NewsView newView) {
        this.newsModel = new NewsModelImpl();
        this.mNewView = newView;
    }


    @Override
    public void loadData() {
        newsModel.loadData(this);
    }

    @Override
    public void onSuccess(ArrayList<NewsDetail> list) {
        mNewView.hideProgress();
        mNewView.addData(list);
    }

    @Override
    public void onFailure(String str, Exception e) {
        mNewView.hideProgress();
        mNewView.showLoadFail();
    }
}
