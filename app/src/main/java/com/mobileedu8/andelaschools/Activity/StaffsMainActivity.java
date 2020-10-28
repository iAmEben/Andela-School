package com.mobileedu8.andelaschools.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobileedu8.andelaschools.R;

public class StaffsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffs_main);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}