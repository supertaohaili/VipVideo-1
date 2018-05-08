package com.marsye.vipvideo.ui.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.marsye.vipvideo.R;
import com.marsye.vipvideo.base.BaseFragment;
import com.marsye.vipvideo.loader.ILoader;
import com.marsye.vipvideo.loader.LoaderManager;
import com.marsye.vipvideo.model.BannerData;
import com.marsye.vipvideo.ui.activity.VideoWebActivity;
import com.marsye.vipvideo.widget.RecyclerViewBanner;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.socks.library.KLog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tbl)
    QMUITopBar mTbl;
    @BindView(R.id.rv_banner)
    RecyclerViewBanner mRvBanner;

    private Document mDocument;
    private List<BannerData> mData = new ArrayList<>();

    @Override
    protected int getMainView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        mTbl.setTitle(getResources().getString(R.string.tab_home));

        mRvBanner.setOnSwitchRvBannerListener(new RecyclerViewBanner.OnSwitchRvBannerListener() {
            @Override
            public void switchBanner(int position, AppCompatImageView bannerView) {
                KLog.e("图片的地址为：" + mData.get(position).getImgUrl());
                LoaderManager.getLoader().loadNet(bannerView,
                        mData.get(position).getImgUrl(),
                        ILoader.Options.defaultOptions());
            }
        });
        mRvBanner.setIndicatorInterval(3000);
        //轮播图点击事件
        mRvBanner.setOnRvBannerClickListener(new RecyclerViewBanner.OnRvBannerClickListener() {
            @Override
            public void onClick(int position) {
            }
        });

        new MyTask().execute();
    }

    @OnClick({R.id.tv_tencent_menu, R.id.tv_aiqiyi_menu, R.id.tv_youku_menu, R.id.tv_le_menu, R.id.tv_pptv_menu, R.id.tv_sohu_menu, R.id.tv_imgo_menu, R.id.tv_1905_menu})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_tencent_menu://腾讯视频
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_tencent_menu));
                intent.putExtra("url", getResources().getString(R.string.tencent_url));
                break;
            case R.id.tv_aiqiyi_menu://爱奇艺视频
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_aiqiyi_menu));
                intent.putExtra("url", getResources().getString(R.string.aiqiyi_url));
                break;
            case R.id.tv_youku_menu://优酷视频
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_youku_menu));
                intent.putExtra("url", getResources().getString(R.string.youk_url));
                break;
            case R.id.tv_le_menu://乐视视频
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_le_menu));
                intent.putExtra("url", getResources().getString(R.string.lev_url));
                break;
            case R.id.tv_pptv_menu://PPTV视频
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_pptv_menu));
                intent.putExtra("url", getResources().getString(R.string.pptv_url));
                break;
            case R.id.tv_sohu_menu://搜狐视频
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_sohu_menu));
                intent.putExtra("url", getResources().getString(R.string.sohu_url));
                break;
            case R.id.tv_imgo_menu://芒果TV
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_imgo_menu));
                intent.putExtra("url", getResources().getString(R.string.imgo_url));
                break;
            case R.id.tv_1905_menu://电影网
                intent = new Intent(mContext, VideoWebActivity.class);
                intent.putExtra("title", getResources().getString(R.string.home_1905_menu));
                intent.putExtra("url", getResources().getString(R.string.film_1905_url));
                break;
        }
        startActivity(intent);
    }

    private class MyTask extends AsyncTask<Void, Void, List<BannerData>> {

        @Override
        protected List<BannerData> doInBackground(Void... params) {
            try {
                // document = Jsoup.connect(urlString).get();
                // 将html字符串解析为document对象
                mDocument = Jsoup.connect("http://m.360kan.com/").get();
                Elements elements = mDocument.select("a.swiper-slide");
                if (mData.size() > 0) {
                    mData.clear();
                }
                for (Element e : elements) {
                    BannerData bean = new BannerData();
                    bean.setTitle(e.select("span").text());
                    bean.setImgUrl(e.select("img").attr("src"));
                    bean.setLinkUrl("http://m.360kan.com" + e.attr("href"));

                    mData.add(bean);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return mData;
        }

        @Override
        protected void onPostExecute(List<BannerData> result) {
            super.onPostExecute(result);

            if (result != null && result.size() > 0) {
                mRvBanner.setRvBannerData(result);
            }
        }
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {
    }
}
