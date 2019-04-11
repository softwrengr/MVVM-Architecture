package com.sessionretrofitvidloginviewmodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sessionretrofitvidloginviewmodel.utilities.GeneralUtills;
import com.sessionretrofitvidloginviewmodel.view.HomeFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        GeneralUtills.connectFragment(this, new HomeFragment());
    }
}
