package com.mobileedu8.andelaschools.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileedu8.andelaschools.Adapters.StudentsRegisterAdapter;
import com.mobileedu8.andelaschools.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentsRegisterFragrament#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentsRegisterFragrament extends Fragment {

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

        initId(v);
        return v;
}

    private void initId(View v) {

    }
    }