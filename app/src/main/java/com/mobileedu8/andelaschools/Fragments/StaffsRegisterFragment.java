package com.mobileedu8.andelaschools.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mobileedu8.andelaschools.Adapters.StaffsRegisterAdapter;
import com.mobileedu8.andelaschools.Adapters.StudentsRegisterAdapter;
import com.mobileedu8.andelaschools.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;


public class StaffsRegisterFragment extends Fragment implements Validator.ValidationListener {

    Validator validator;

    private ScrollView rootView;

    @NotEmpty
    @Length(min = 2, max = 30, message = "First name should be between 2 to 30 characters")
    private EditText staffFirstNameEditText;

    @NotEmpty
    @Length(min = 2, max = 30, message = "Last name should be between 2 to 30 characters")
    private EditText staffLastBaneEditText;

    @Email
    private EditText staffEmailEditText;

    @Password(min = 6, message = "Invalid password, password should be above 6 characters")
    private EditText staffPasswordEditText;

    @Checked(message = "You must agree to terms and condition")
    private CheckBox agreeToTCCheckBox;

    private Button staffSignUpBtn;

    private StaffsRegisterAdapter adapter;
    private androidx.cardview.widget.CardView cardView;

    public StaffsRegisterFragment(){
        // Required empty public constructor
    }

    public static StaffsRegisterFragment newInstance(){
        return new StaffsRegisterFragment();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_staffs_register, container, false);
        adapter = new StaffsRegisterAdapter();


        setUpValidations();
        initId(v);
        return v;
    }

    private void setUpValidations() {
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    private void initId(View v) {

        rootView = v.findViewById(R.id.staff_sign_up_root_view);
        staffFirstNameEditText = v.findViewById(R.id.staffs_name);
        staffLastBaneEditText = v.findViewById(R.id.staffs_lastName);
        staffEmailEditText = v.findViewById(R.id.staffs_email);
        staffPasswordEditText = v.findViewById(R.id.staff_password);
        agreeToTCCheckBox = v.findViewById(R.id.agree_to_tc);
        staffSignUpBtn = v.findViewById(R.id.staff_sign_up_btn);

        staffSignUpBtn.setOnClickListener(view -> {
            validator.validate();
        });

    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(getActivity(), "Validation Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error: errors) {
            View view = error.getView();

            if (view instanceof EditText) {
                ((EditText) view).setError(error.getCollatedErrorMessage(getActivity()));
            }

            if (view instanceof CheckBox && errors.size() == 1) {
                Snackbar.make(rootView, error.getCollatedErrorMessage(getActivity()), Snackbar.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        validator = null;
    }
}