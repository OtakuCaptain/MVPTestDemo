package com.chen.mvptestdemo.presenter;

import com.chen.mvptestdemo.bean.NewsDetail;
import com.chen.mvptestdemo.model.NewsModel;
import com.chen.mvptestdemo.model.NewsModelImpl;
import com.chen.mvptestdemo.view.NewsView;

import java.util.ArrayList;
import java.util.List;

public class NewsPresenterImpl implements NewsPresenter, NewsModelImpl.OnLoadNewsDataListener {

    private NewsView mNewView;
    private NewsModel newsModel;


    public NewsPresenterImpl(NewsView newsView) {
        this.newsModel = new NewsModelImpl();
        this.mNewView = newsView;
    }


    @Override
    public void getData() {
        newsModel.requestFromServer(this);
    }

    @Override
    public void onSuccess(List<NewsDetail> list) {
        mNewView.hideProgress();
        mNewView.addData(list);
    }

    @Override
    public void onFailure(String str, Exception e) {
        mNewView.hideProgress();
        mNewView.showLoadFail();
    }
}
