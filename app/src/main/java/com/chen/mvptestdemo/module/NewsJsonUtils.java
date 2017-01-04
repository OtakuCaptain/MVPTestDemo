package com.chen.mvptestdemo.module;

import com.chen.mvptestdemo.model.NewsModel;
import com.chen.mvptestdemo.utils.JsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */

public class NewsJsonUtils {
    public static ArrayList<NewsModel> readJsonNewsBeans(String response) {
        ArrayList<NewsModel> bean = new ArrayList<>();
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(response).getAsJsonArray();
//            JsonElement jsonElement = jsonObject.get(value);
//            if (jsonElement == null) {
//                return null;
//            }
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                NewsModel newsBean = JsonUtils.deserialize(jo, NewsModel.class);
                bean.add(newsBean);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
