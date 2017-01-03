package com.chen.mvptestdemo.model;

import com.chen.mvptestdemo.db.NewsBean;
import com.chen.mvptestdemo.utils.NewsJsonUtils;
import com.chen.mvptestdemo.utils.OkHttpUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by chen on 2017-01-03.
 */

public class NewsModelImpl implements NewsModel{
    @Override
    public void loadData(final String url,final int type,final OnLoadNewsDataListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback=new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsBean> dataBeans = NewsJsonUtils.readJsonNewsBeans(response,getId(type));
                listener.onSuccess(dataBeans);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.",e);

            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    private String getId(int type) {
        return null;
    }

    @Override
    public void loadDetilData(String url) {

    }

    public interface OnLoadNewsDataListener{
        void  onSuccess(List<NewsBean> list);
        void  onFailure(String str,Exception e);
    }
//    public interface OnloadFirstDataDetilListener{
//        void onSuccess(DataDetilBean list);
//        void onFailure(String str,Exception e);
//    }
}
