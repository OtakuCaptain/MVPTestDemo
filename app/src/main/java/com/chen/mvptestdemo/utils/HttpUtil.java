package com.chen.mvptestdemo.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){

        final CacheControl.Builder builder = new CacheControl.Builder();
        builder.maxAge(10, TimeUnit.MILLISECONDS);
        CacheControl cache = builder.build();
        OkHttpClient client =new OkHttpClient();
         Request request = new Request.Builder().cacheControl(cache).url(address).build();

//        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

}
