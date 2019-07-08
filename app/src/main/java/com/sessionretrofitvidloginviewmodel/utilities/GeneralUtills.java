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

}
