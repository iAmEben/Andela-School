package com.mobileedu8.andelaschools.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobileedu8.andelaschools.R;

public class LoginScreen extends AppCompatActivity {

    //UI's
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initID();

        //sets an onclick listener for the buttons
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(LoginScreen.this, LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginScreen.this, RegisterActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });
    }

    //finds relevant id's for initialization
    private void initID() {
        login = findViewById(R.id.button_login);
        register = findViewById(R.id.button_register);
    }

}