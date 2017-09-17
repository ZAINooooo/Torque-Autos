package com.example.asim.customlistview.wishlist_work;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by Zahoor on 2/21/2017.
 */

public class Constantsdialoque {
    static ProgressDialog loading;
    public static void showlDialog(Activity context){
        loading = new ProgressDialog(context);
        loading.setMessage("Loading....");
        loading.setCancelable(false);
        loading.show();
    }
    public static void dismisDialog(){
        //   loading = new ProgressDialog(context);
        loading.dismiss();
    }
}
