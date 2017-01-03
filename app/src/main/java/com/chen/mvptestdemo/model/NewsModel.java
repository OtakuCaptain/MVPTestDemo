package com.chen.mvptestdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chen on 2017-01-03.
 */

public class NewsModel {

    private int id;
    private String name;
    @SerializedName("picSmall")
    private String picsmall;
    @SerializedName("picBig")
    private String picbig;
    private String description;
    private int learner;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPicsmall(String picsmall) {
        this.picsmall = picsmall;
    }
    public String getPicsmall() {
        return picsmall;
    }

    public void setPicbig(String picbig) {
        this.picbig = picbig;
    }
    public String getPicbig() {
        return picbig;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setLearner(int learner) {
        this.learner = learner;
    }
    public int getLearner() {
        return learner;
    }

}
