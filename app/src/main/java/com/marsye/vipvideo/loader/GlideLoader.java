package com.marsye.vipvideo.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.marsye.vipvideo.GlideApp;

import java.io.File;

/**
 * @Description: 使用Glide框架加载图片
 * @author: <a href="http://www.xiaoyaoyou1212.com">DAWI</a>
 * @date: 2016-12-19 15:16
 */
public class GlideLoader implements ILoader {

    @Override
    public void init(Context context) {
        try {
            Class.forName("com.bumptech.glide.Glide");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Must be dependencies Glide!");
        }
    }

    public void loadNet(ImageView target, String url) {
        loadNet(target, url, ILoader.Options.defaultOptions());
    }

    @Override
    public void loadNet(ImageView target, String url, Options options) {
        if (options.transformation != null) {
            GlideApp.with(target.getContext())
                    .load(url)
                    .transform(options.transformation)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        } else {
            GlideApp.with(target.getContext())
                    .load(url)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        }
    }

    public void loadResource(ImageView target, int resId) {
        loadResource(target, resId, ILoader.Options.defaultOptions());
    }

    @Override
    public void loadResource(ImageView target, int resId, Options options) {
        if (options.transformation != null) {
            GlideApp.with(target.getContext())
                    .load(resId)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .transform(options.transformation)
                    .into(target);
        } else {
            GlideApp.with(target.getContext())
                    .load(resId)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        }
    }

    public void loadAssets(ImageView target, String assetName) {
        loadAssets(target, assetName, ILoader.Options.defaultOptions());
    }

    @Override
    public void loadAssets(ImageView target, String assetName, Options options) {
        if (options.transformation != null) {
            GlideApp.with(target.getContext())
                    .load("file:///android_asset/" + assetName)
                    .transform(options.transformation)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        } else {
            GlideApp.with(target.getContext())
                    .load("file:///android_asset/" + assetName)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        }
    }

    public void loadFile(ImageView target, File file) {
        loadFile(target, file, ILoader.Options.defaultOptions());
    }

    @Override
    public void loadFile(ImageView target, File file, Options options) {
        if (options.transformation != null) {
            GlideApp.with(target.getContext())
                    .load(file)
                    .transform(options.transformation)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        } else {
            GlideApp.with(target.getContext())
                    .load(file)
                    .placeholder(options.loadingResId)
                    .error(options.loadErrorResId)
                    .into(target);
        }
    }

    @Override
    public void clearMemoryCache(Context context) {
        Glide.get(context).clearMemory();
    }

    @Override
    public void clearDiskCache(Context context) {
        Glide.get(context).clearDiskCache();
    }
}
