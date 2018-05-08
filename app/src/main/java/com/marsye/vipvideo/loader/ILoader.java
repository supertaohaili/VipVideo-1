package com.marsye.vipvideo.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.load.Transformation;
import com.marsye.vipvideo.constants.Constants;

import java.io.File;

/**
 * @Description: 图片加载接口
 * @author: <a href="http://xiaoyaoyou1212.360doc.com">DAWI</a>
 * @date: 2016-12-19 15:04
 */
public interface ILoader {

    void init(Context context);

    void loadNet(ImageView target, String url, Options options);

    void loadResource(ImageView target, int resId, Options options);

    void loadAssets(ImageView target, String assetName, Options options);

    void loadFile(ImageView target, File file, Options options);

    void clearMemoryCache(Context context);

    void clearDiskCache(Context context);

    class Options {

        public static final int RES_NONE = -1;
        public int loadingResId = RES_NONE;//加载中的资源id
        public int loadErrorResId = RES_NONE;//加载失败的资源id
        public Transformation<Bitmap> transformation;//加载特殊图片，如：圆形，圆角

        public static Options defaultOptions() {
            return new Options(Constants.IL_LOADING_RES, Constants.IL_ERROR_RES);
        }

        public Options(int loadingResId, int loadErrorResId) {
            this.loadingResId = loadingResId;
            this.loadErrorResId = loadErrorResId;
        }

        public Options(int loadingResId, int loadErrorResId,Transformation<Bitmap> transformation) {
            this.loadingResId = loadingResId;
            this.loadErrorResId = loadErrorResId;
            this.transformation=transformation;
        }
    }
}
