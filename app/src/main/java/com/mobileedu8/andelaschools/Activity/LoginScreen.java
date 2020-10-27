package com.mobileedu8.andelaschools.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobileedu8.andelaschools.R;
import com.mobileedu8.andelaschools.firebase.auth.AuthService;
import com.mobileedu8.andelaschools.utils.Prefs;

import static com.mobileedu8.andelaschools.utils.Constants.STAFF_MODE;
import static com.mobileedu8.andelaschools.utils.Constants.STUDENT_MODE;

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

        if (AuthService.getInstance().getUser() != null)
            switch (Prefs.getUserMode(this)) {
                case STAFF_MODE:
                    startActivity(new Intent(this, StaffsMainActivity.class));
                    finish();
                    break;
                case STUDENT_MODE:
                    startActivity(new Intent(this, StudentsMainActivity.class));
                    finish();
                    break;
            }

    }

    //finds relevant id's for initialization
    private void initID() {
        login = findViewById(R.id.button_login);
        register = findViewById(R.id.button_register);
    }

}