package com.example.rbac.phongsak.mai.myrbac.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.rbac.phongsak.mai.myrbac.R;

/**
 * Created by Administrator on 6/8/2560.
 */
public class MyAlert {
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle,String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_name);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();//exit dialog

            }
        });
        builder.show();
    }


}
