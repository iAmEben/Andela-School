package com.mobileedu8.andelaschools.firebase.auth;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobileedu8.andelaschools.Dbentities.Lecturer;
import com.mobileedu8.andelaschools.firebase.db.DBService;
import com.mobileedu8.andelaschools.utils.Prefs;

import static com.mobileedu8.andelaschools.utils.Constants.STAFF_MODE;

public class AuthService {

    private static AuthService INSTANCE = null;

    private FirebaseAuth firebaseAuth;

    private AuthService() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static AuthService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthService();
        }

        return INSTANCE;
    }

    public void login(String email, String password, OnLoginComplete onLoginComplete) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    onLoginComplete.loginSuccess(task);
                } else {
                    onLoginComplete.loginFailure(task);
                }
            }
        });
    }

    public void registerLecturer(@NonNull Context context, @NonNull Lecturer lecturer, OnRegisterComplete onRegisterComplete) {

        firebaseAuth.createUserWithEmailAndPassword(lecturer.getEmail(), lecturer.getPassword())
                .addOnCompleteListener(task -> {
                    final Task<AuthResult> authResultTask = task;
                    if (task.isSuccessful()) {
                        String id = firebaseAuth.getUid();
                        DBService.getInstance().addNewLecturer(lecturer, id, new DBService.OnDBTaskComplete() {
                            @Override
                            public void onSuccess(@NonNull Task<Void> task) {
                                firebaseAuth.getCurrentUser().sendEmailVerification();
                                if (Prefs.setUserMode(STAFF_MODE, context)) {
                                    onRegisterComplete.registerSuccess(authResultTask, id, firebaseAuth.getCurrentUser());
                                } else {
                                    onRegisterComplete.registerFailure(authResultTask);
                                }
                            }

                            @Override
                            public void onFailure(@NonNull Task<Void> task) {
                                onRegisterComplete.registerFailure(authResultTask);
                            }
                        });
                    } else {
                        onRegisterComplete.registerFailure(task);
                    }
                });

    }

    public void registerStudent() {

    }

    public FirebaseUser getUser() {
        return firebaseAuth.getCurrentUser();
    }


    public interface OnLoginComplete {
        void loginSuccess(@NonNull Task<AuthResult> task);

        void loginFailure(@NonNull Task<AuthResult> task);
    }

    public interface OnRegisterComplete {
        void registerSuccess(@NonNull Task<AuthResult> task, @NonNull String id, @NonNull FirebaseUser firebaseUser);

        void registerFailure(@NonNull Task<AuthResult> task);
    }

}
