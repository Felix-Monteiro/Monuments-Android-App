/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project;

import android.app.AlertDialog;
import android.content.Context;

import com.thunder.project.api.MonumentApi;
import com.thunder.project.api.MonumentClient;

public class Utils {

    public static MonumentApi getApi() {
        return MonumentClient.getMonumentClient().create(MonumentApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
