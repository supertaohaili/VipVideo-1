package com.marsye.vipvideo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.marsye.vipvideo.R;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/**
 * 登录失效广播
 * 使用：
 * Intent intent=new Intent();
 * intent.setAction("com.marsye.force_offline");此处为清单文件中设置的Action
 * sendBroadcast(intent);
 */
public class ForceOfflineBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("强制下线广播");
        builder.setMessage("你已被强制下线，请重新登陆。");
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
                Intent intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        AlertDialog alterDialog = builder.create();
        alterDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alterDialog.show();*/

        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("提示")
                .setMessage("登录信息已失效，是否重新登录")
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        /*ActivityCollector.finishAll();//结束所有的Activity
                        Intent intent = new Intent(context, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);*/
                        dialog.dismiss();
                    }
                })
                .create(R.style.QMUI_Dialog).show();
    }
}
