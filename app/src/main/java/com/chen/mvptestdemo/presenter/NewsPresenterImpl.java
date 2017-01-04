package com.chen.mvptestdemo.presenter;

import android.util.Log;

import com.chen.mvptestdemo.commons.Uris;
import com.chen.mvptestdemo.model.NewsModel;
import com.chen.mvptestdemo.module.NewsJsonUtils;
import com.chen.mvptestdemo.utils.HttpUtil;
import com.chen.mvptestdemo.view.NewsView;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NewsPresenterImpl implements NewsPresenter {

    private NewsView mNewView;


    public NewsPresenterImpl(NewsView newView) {
        this.mNewView = newView;
    }


    @Override
    public void loadData(String url) {

        url = Uris.CATEGORY_URL;
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.i("新闻", responseText);
                processData(responseText);
//                ArrayList<NewsModel> newsModels = NewsJsonUtils.readJsonNewsBeans(responseText);
//                listener.onSuccess(newsModels);
            }
        });

    }

    private void processData(String json) {
        Gson gson = new Gson();
        NewsModel newsMenu = gson.fromJson(json, NewsModel.class);
        Log.i("Pager", "解析结果：" + String.valueOf(newsMenu));
    }

}
