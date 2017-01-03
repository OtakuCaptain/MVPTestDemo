package com.chen.mvptestdemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chen.mvptestdemo.R;

/**
 * Created by chen on 2017-01-03.
 */

public class ImageViewLoaderUtils {

    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");

        }
        Glide.with(context).load(url).placeholder(R.mipmap.ic_image_loading)
                .error(R.mipmap.ic_image_loadfail).crossFade().into(imageView);
    }
}
