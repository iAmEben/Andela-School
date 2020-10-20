package com.mobileedu8.andelaschools.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.mobileedu8.andelaschools.Adapters.RegisterAdapter;
import com.mobileedu8.andelaschools.R;

public class RegisterActivity extends AppCompatActivity {

    private RegisterAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView registerBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initID();
        initAction();
    }

    // for activities that requires actions
    private void initAction() {
        registerBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initID() {
        registerBack = (ImageView) findViewById(R.id.registerBack);
        adapter = new RegisterAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        //setup viewpager and TabLayout
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}