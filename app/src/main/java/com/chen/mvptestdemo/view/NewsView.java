package com.chen.mvptestdemo.view;

import com.chen.mvptestdemo.bean.NewsDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */

public interface NewsView {
    void addData(ArrayList<NewsDetail> mList);

    void showProgress();

    void hideProgress();

    void showLoadFail();
}
