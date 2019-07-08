package com.sessionretrofitvidloginviewmodel.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sessionretrofitvidloginviewmodel.R;
import com.sessionretrofitvidloginviewmodel.utilities.GeneralUtills;
import com.sessionretrofitvidloginviewmodel.view.fragments.HomeFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        GeneralUtills.connectFragmentWithoutBack(this, new HomeFragment());
    }
}
