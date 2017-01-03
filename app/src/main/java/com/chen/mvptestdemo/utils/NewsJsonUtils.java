package com.chen.mvptestdemo.utils;

import android.text.TextUtils;

import com.chen.mvptestdemo.db.NewsBean;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */

public class NewsJsonUtils {

    public static List<NewsBean> readJsonNewsBeans(String response, String value) {

        List<NewsBean> bean = new ArrayList<>();

        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(response).getAsJsonObject();
            JsonElement jsonElement = jsonObject.get(value);
            if (jsonElement == null) {
                return null;
            }
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                NewsBean newsBean = JsonUtils.deserialize(jo, NewsBean.class);
                bean.add(newsBean);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
