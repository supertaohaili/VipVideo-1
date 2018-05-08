package com.marsye.vipvideo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.marsye.vipvideo.utils.ActivityManager;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.socks.library.KLog;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getMainView());
        mContext = this;
        ActivityManager.getInstance().addActivity(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(this); // 沉浸式状态栏
        ButterKnife.bind(this);
        init();
        setListener();
    }

    /**
     * 主体界面，继承者自己实现
     */
    protected abstract int getMainView();

    //一些初始化操作
    protected void init() {
    }

    //设置监听
    protected void setListener() {
    }

    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        KLog.i("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        KLog.i("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        KLog.i("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        KLog.i("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        KLog.i("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.i("onDestroy");
        ActivityManager.getInstance().removeActivity(this);
    }
}
