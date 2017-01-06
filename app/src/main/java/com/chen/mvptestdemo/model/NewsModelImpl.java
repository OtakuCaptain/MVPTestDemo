package com.chen.mvptestdemo.model;

import android.util.Log;

import com.chen.mvptestdemo.bean.NewsBean;
import com.chen.mvptestdemo.bean.NewsDetail;
import com.chen.mvptestdemo.commons.Uris;
import com.chen.mvptestdemo.utils.HttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class NewsModelImpl implements NewsModel {


    @Override
    public void requestFromServer(final OnLoadNewsDataListener listener) {
        String url = Uris.TOP_URL;
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                listener.onFailure("获取数据失败", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String responseText = response.body().string();
                Log.i("新闻", "onResponse: "+responseText);
                ArrayList<NewsDetail> newsDetails = processData(responseText);
                listener.onSuccess(newsDetails);
            }
        });
    }


    public ArrayList<NewsDetail> processData(String response) {

        Gson gson = new Gson();
        NewsBean newsBean = gson.fromJson(response, NewsBean.class);
        Log.i("新闻", "解析结果: "+ String.valueOf(newsBean));
        return newsBean.data;

    }


}
