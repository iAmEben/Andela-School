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
import com.mobileedu8.andelaschools.Adapters.StudentsRegisterAdapter;
import com.mobileedu8.andelaschools.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentsRegisterFragrament#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentsRegisterFragrament extends Fragment implements Validator.ValidationListener {

    private Validator validator;

    private ScrollView rootView;

    @NotEmpty
    @Length(min = 2, max = 30, message = "First name should be between 2 to 30 characters")
    private EditText studentFirstNameEditText;

    @NotEmpty
    @Length(min = 2, max = 30, message = "Last name should be between 2 to 30 characters")
    private EditText studentLastNameEditText;

    @Email
    private EditText studentEmailEditText;

    @Password
    private EditText studentPasswordEditText;

    @NotEmpty
    @Length(min = 3, max = 30)
    private EditText studentCourseOfferingEditText;

    @Min(value = 100, message = "Should not be less than 100")
    @Max(value = 700, message = "Should not be greater than 700")
    private EditText studentLevelEditText;

    @Checked(message = "You must accept the terms and conditions")
    private CheckBox studentAcceptTermsCheckBox;

    private Button studentSignUpBtn;

    private StudentsRegisterAdapter adapter;

    public StudentsRegisterFragrament(){
        // Required empty public constructor
    }

    public static StudentsRegisterFragrament newInstance(){
        return new StudentsRegisterFragrament();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_students_register_fragrament, container, false);
        adapter = new StudentsRegisterAdapter();

        setUpValidation();

        initId(v);
        return v;
    }

    private void setUpValidation() {
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    private void initId(View v) {

        rootView = v.findViewById(R.id.student_sign_up_root_view);
        studentFirstNameEditText = v.findViewById(R.id.student_name);
        studentLastNameEditText = v.findViewById(R.id.student_lastName);
        studentEmailEditText = v.findViewById(R.id.student_email);
        studentPasswordEditText = v.findViewById(R.id.student_password);
        studentCourseOfferingEditText = v.findViewById(R.id.course_offered);
        studentLevelEditText = v.findViewById(R.id.level);
        studentAcceptTermsCheckBox = v.findViewById(R.id.student_accept_tc);
        studentSignUpBtn = v.findViewById(R.id.student_sign_up_btn);

        View.OnClickListener studentSignUpListener = (View view) -> validator.validate();;
        studentSignUpBtn.setOnClickListener(studentSignUpListener);

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

            if (errors.size() == 1 && view instanceof  CheckBox) {
                Snackbar.make(rootView, error.getCollatedErrorMessage(getActivity()), Snackbar.LENGTH_LONG).show();
            }
        }

    }
}