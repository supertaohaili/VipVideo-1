package com.marsye.vipvideo.ui.fragment;

import com.marsye.vipvideo.R;
import com.marsye.vipvideo.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;

public class MessageFragment extends BaseFragment {

    @BindView(R.id.tbl)
    QMUITopBar mTbl;

    @Override
    protected int getMainView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initData() {
        mTbl.setTitle(getResources().getString(R.string.tab_message));
    }

    @Override
    protected void setDefaultFragmentTitle(String title) {
    }
}
