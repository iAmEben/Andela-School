package com.mobileedu8.andelaschools.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobileedu8.andelaschools.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements Validator.ValidationListener {

    private Validator validator;

    private Spinner loginModeSpinner;

    private ConstraintLayout rootView;

    @Email
    private EditText emailEditText;

    @Password
    private EditText passwordEditText;

    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpValidation();

        initViews();

    }

    private void setUpValidation() {
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    private void initViews() {
        rootView = findViewById(R.id.login_root_view);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);

        loginModeSpinner = findViewById(R.id.login_modes_spinner);
        ArrayAdapter<CharSequence> loginModeSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.login_modes, R.layout.spinner_item_layout);
        loginModeSpinnerAdapter.setDropDownViewResource(R.layout.spinner_drop_down_layout);
        loginModeSpinner.setAdapter(loginModeSpinnerAdapter);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error: errors) {
            View view = error.getView();

            if (view instanceof EditText) {
                ((EditText) view).setError(error.getCollatedErrorMessage(this));
            }
        }

    }

    @Override
    protected void onDestroy() {
        validator = null;
        super.onDestroy();
    }

}