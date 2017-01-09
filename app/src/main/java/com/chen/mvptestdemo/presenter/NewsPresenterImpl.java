package com.chen.mvptestdemo.presenter;

import android.util.Log;

import com.chen.mvptestdemo.bean.NewsDetail;
import com.chen.mvptestdemo.model.NewsModel;
import com.chen.mvptestdemo.model.NewsModelImpl;
import com.chen.mvptestdemo.view.NewsView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class NewsPresenterImpl implements NewsPresenter, NewsModelImpl.OnLoadNewsDataListener {

    private NewsView mNewView;
    private NewsModel newsModel;


    public NewsPresenterImpl(NewsView newsView) {
        this.newsModel = new NewsModelImpl();
        this.mNewView = newsView;
    }


    @Override
    public void getData() {
        Log.i(TAG, "getData: ==========");
        mNewView.showProgress();
        newsModel.requestFromServer(this);
    }

    @Override
    public void onSuccess(ArrayList<NewsDetail> list) {
        if (null != list) {

            mNewView.addData(list);
            mNewView.hideProgress();
        }
    }

    @Override
    public void onFailure(String str, Exception e) {

        mNewView.showLoadFail();
        mNewView.hideProgress();
    }
}
