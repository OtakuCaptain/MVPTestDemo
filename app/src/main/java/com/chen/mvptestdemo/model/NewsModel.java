package com.chen.mvptestdemo.model;

import com.chen.mvptestdemo.bean.NewsDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017-01-05.
 */

public interface NewsModel {

    interface OnLoadNewsDataListener {
        void onSuccess(ArrayList<NewsDetail> list);

        void onFailure(String str, Exception e);
    }

    void requestFromServer(OnLoadNewsDataListener listener);

}
