package com.marsye.vipvideo.ui.activity;

import com.marsye.vipvideo.R;
import com.marsye.vipvideo.base.BaseActivity;
import com.marsye.vipvideo.ui.MainActivity;
import com.marsye.vipvideo.widget.RoundProgressBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.btn_rpb)
    RoundProgressBar mBtnRpb;

    @Override
    protected int getMainView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void setListener() {
        mBtnRpb.setProgressChangeListener(new RoundProgressBar.ProgressChangeListener() {
            @Override
            public void onFinish() {
                startActivity(MainActivity.class);
                finish();
            }

            @Override
            public void onProgressChanged(int progress) {
            }
        });
    }

    @OnClick(R.id.btn_rpb)
    public void onClick() {
        mBtnRpb.stop();
        startActivity(MainActivity.class);
        finish();
    }
}
