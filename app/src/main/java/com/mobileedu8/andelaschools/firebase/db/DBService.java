package com.mobileedu8.andelaschools.firebase.db;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mobileedu8.andelaschools.Dbentities.Lecturer;

import static com.mobileedu8.andelaschools.utils.Constants.DB_STAFF_COLLECTION;

public class DBService {

    private static DBService INSTANCE = null;

    private FirebaseFirestore firestore;

    private DBService() {
        firestore = FirebaseFirestore.getInstance();
    }

    public static DBService getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DBService();

        return INSTANCE;
    }

    public void addNewLecturer(Lecturer lecturer, String id, OnDBTaskComplete onDBTaskComplete) {
        firestore.collection(DB_STAFF_COLLECTION)
                .document(id)
                .set(lecturer)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        onDBTaskComplete.onSuccess(task);
                    } else {
                        onDBTaskComplete.onFailure(task);
                    }
                });
    }


    public interface OnDBTaskComplete {
        void onSuccess(@NonNull Task<Void> task);

        void onFailure(@NonNull Task<Void> task);
    }

}
