package com.chen.mvptestdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class NewsBean {
    @Override
    public String toString() {
        return "NewsBean{" +
                "data=" + data +
                '}';
    }

    @SerializedName("T1348647909107")
    public ArrayList<NewsDetail> data;
}
