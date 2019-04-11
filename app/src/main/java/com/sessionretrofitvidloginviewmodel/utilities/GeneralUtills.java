package com.sessionretrofitvidloginviewmodel.utilities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sessionretrofitvidloginviewmodel.R;

import java.util.List;

public class GeneralUtills {


    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static Fragment connectFragment(Context context, Fragment fragment) {
        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("true").commit();
        return fragment;
    }

    public static Fragment connectFragmentWithoutBack(Context context, Fragment fragment) {
        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        return fragment;
    }

    public static SharedPreferences.Editor putStringValueInEditor(Context context, String key, String value) {
        sharedPreferences = getSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.putString(key, value).commit();
        return editor;
    }

    public static SharedPreferences.Editor putIntegerValueInEditor(Context context, String key, int value) {
        sharedPreferences = getSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.putInt(key, value).commit();
        return editor;
    }

    public static SharedPreferences.Editor putBooleanValueInEditor(Context context, String key, boolean value) {
        sharedPreferences = getSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.putBoolean(key, value).commit();
        return editor;
    }



    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("MVVM", 0);
    }

    public static int getItemID(Context context){
        return getSharedPreferences(context).getInt("itemID",0);
    }



    public static boolean isLogin(Context context){
        return getSharedPreferences(context).getBoolean("isLogin",false);
    }

    public static String getLocation(Context context){
        return getSharedPreferences(context).getString("location","");
    }



}
