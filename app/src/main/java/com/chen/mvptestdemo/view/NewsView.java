package com.chen.mvptestdemo.view;

import com.chen.mvptestdemo.db.NewsBean;

import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */

public interface NewsView {
    void addData(List<NewsBean> mList);

    void showProgress();

    void hideProgress();

    void showLoadFail();
}
