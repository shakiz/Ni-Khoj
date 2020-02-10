package com.shakil.ni_khoj.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class UtilsManager {
    private static Context context;

    public UtilsManager(Context context) {
        this.context = context;
    }

    public static void exitApp(Context context){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(exitIntent);
    }

    public static void printLog(String tag, String message){
        Log.v("shakil",tag+"<<<>>>"+message);
    }

    public static void toast( String message, Context context){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
