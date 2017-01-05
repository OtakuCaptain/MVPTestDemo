package com.chen.mvptestdemo.model;

/**
 * Created by chen on 2017-01-05.
 */

public interface NewsModel {
    void loadData(final NewsModelImpl.OnLoadNewsDataListener listener);
}
