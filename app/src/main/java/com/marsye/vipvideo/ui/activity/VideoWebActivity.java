package com.marsye.vipvideo.ui.activity;

import com.marsye.vipvideo.R;
import com.marsye.vipvideo.base.BaseActivity;
import com.marsye.vipvideo.widget.X5WebView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;

public class VideoWebActivity extends BaseActivity {

    @BindView(R.id.tbl)
    QMUITopBar mTbl;
    @BindView(R.id.wv_content)
    X5WebView mWvContent;

    @Override
    protected int getMainView() {
        return R.layout.activity_video_web;
    }

    @Override
    protected void init() {
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");

        mTbl.setTitle(title);
        mWvContent.loadUrl(url);

        /*mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                KLog.e(s);
                return true;
            }
        });*/
    }
}
