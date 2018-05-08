package com.marsye.vipvideo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.marsye.vipvideo.R;
import com.marsye.vipvideo.base.BaseActivity;
import com.marsye.vipvideo.ui.fragment.AccountFragment;
import com.marsye.vipvideo.ui.fragment.ActivityFragment;
import com.marsye.vipvideo.ui.fragment.HomeFragment;
import com.marsye.vipvideo.ui.fragment.MessageFragment;
import com.qmuiteam.qmui.widget.QMUITabSegment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabs)
    QMUITabSegment mTabs;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;

    private TabPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getMainView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        //将所有fragment加入到集合当中
        mFragments.add(new HomeFragment());
        mFragments.add(new ActivityFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new AccountFragment());
        //初始化Tab
        int normalColor = ContextCompat.getColor(mContext, R.color.color_gray);
        int selectColor = ContextCompat.getColor(mContext, R.color.color_green);
        mTabs.setDefaultNormalColor(normalColor);
        mTabs.setDefaultSelectedColor(selectColor);

        QMUITabSegment.Tab home = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_home),
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_home_selected),
                getResources().getString(R.string.tab_home), false
        );
        QMUITabSegment.Tab activity = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_activity),
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_activity_selected),
                getResources().getString(R.string.tab_activity), false
        );
        QMUITabSegment.Tab message = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_message),
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_message_selected),
                getResources().getString(R.string.tab_message), false
        );
        QMUITabSegment.Tab account = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_account),
                ContextCompat.getDrawable(mContext, R.mipmap.ic_tab_account_selected),
                getResources().getString(R.string.tab_account), false
        );

        mTabs.reset();
        mTabs.addTab(home);
        mTabs.addTab(activity);
        mTabs.addTab(message);
        mTabs.addTab(account);

        //初始化ViewPager
        mAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mAdapter.setFragments(mFragments);
        mVpContent.setAdapter(mAdapter);
        mTabs.setupWithViewPager(mVpContent, false);
        mTabs.setMode(QMUITabSegment.MODE_FIXED);
    }

    public class TabPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList;

        public void setFragments(List<Fragment> fragments) {
            mFragmentList = fragments;
        }

        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = mFragmentList.get(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
