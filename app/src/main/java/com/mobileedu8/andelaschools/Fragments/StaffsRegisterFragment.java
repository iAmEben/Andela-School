package com.mobileedu8.andelaschools.Fragments;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mobileedu8.andelaschools.Activity.LoginActivity;
import com.mobileedu8.andelaschools.Adapters.StaffsRegisterAdapter;
import com.mobileedu8.andelaschools.Dbentities.Lecturer;
import com.mobileedu8.andelaschools.R;



public class StaffsRegisterFragment extends Fragment {

    private StaffsRegisterAdapter adapter;
    private androidx.cardview.widget.CardView cardView;

    private Button staffRegisterBtn;
    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private CheckBox checkBox;
    private TextView staffLogin;

    private StaffsRegisterFragment(){
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



        initId(v);
        return v;
    }

    private void initId(final View v) {

        // Locate all necessary views and assign them to the instance variables
        staffRegisterBtn = v.findViewById(R.id.staffRegisterBtn);

        // Input fields for lecturer account registration
        firstNameInput = v.findViewById(R.id.staffs_name);
        lastNameInput = v.findViewById(R.id.staffs_lastName);
        emailInput = v.findViewById(R.id.staffs_email);
        passwordInput = v.findViewById(R.id.password);
        checkBox = v.findViewById(R.id.staff_terms_and_condition);
        staffLogin = v.findViewById(R.id.staff_login);

        goToLogInActivity();

        // Handle event click register button to add new lecturer
        staffRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * @author Andrews Kangah
                 * @Date 21-10-2020
                 * Call {@link com.mobileedu8.andelaschools.Fragments#isInputValid() } to check if user entered all required account details
                 * If provided then proceed to registration
                 */
                if ( isInputValid() && checkBox.isChecked() ) {

                    // Create new lecturer with values from input fields
                    Lecturer newLecturer = new Lecturer(
                            firstNameInput.getText().toString(),
                            lastNameInput.getText().toString(),
                            emailInput.getText().toString(),
                            passwordInput.getText().toString()
                    );

                    // Get reference to firebase instance
                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    // Add new lecturer to the staff collection
                    db.collection("staff")
                            .add(newLecturer)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    clearField();
                                    Toast.makeText(v.getContext(),
                                            "Lecturer account create success", Toast.LENGTH_LONG).show();
                                    Intent staffSignUpIntent = new Intent(getContext(), LoginActivity.class);
                                    startActivity(staffSignUpIntent);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(v.getContext(),
                                            "Lecturer account create failed", Toast.LENGTH_LONG).show();
                                }
                            });

                }
                else if(isInputValid() && !(checkBox.isChecked())){

                    Toast.makeText(v.getContext(),
                            "Accept terms and Condition before you can continue", Toast.LENGTH_LONG).show();

                }

                else {

                    Toast.makeText(v.getContext(),
                            "Some required fields are empty. Try again", Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    // Check if user entered values in all input fields
    private boolean isInputValid() {

        return !(
                firstNameInput.getText().toString().isEmpty() ||
                        lastNameInput.getText().toString().isEmpty() ||
                        emailInput.getText().toString().isEmpty() ||
                        passwordInput.getText().toString().isEmpty()
        );
    }
    // Set field to empty when registration is successful
    public void clearField(){
        firstNameInput.setText("");
        lastNameInput.setText("");
        emailInput.setText("");
        passwordInput.setText("");
    }

    //Handles click event to Login activity
    private void goToLogInActivity(){
        staffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent staffLoginIntent = new Intent(getContext(), LoginActivity.class);
                startActivity(staffLoginIntent);
            }
        });
    }
}