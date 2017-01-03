package com.chen.mvptestdemo.model;

/**
 * Created by chen on 2017-01-03.
 */

public interface NewsModel {
    void loadData(final String url,final int type,final NewsModelImpl.OnLoadNewsDataListener listener);
    void loadDetilData(String url);
}
