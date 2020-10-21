package com.mobileedu8.andelaschools.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileedu8.andelaschools.Adapters.StaffsRegisterAdapter;
import com.mobileedu8.andelaschools.Adapters.StudentsRegisterAdapter;
import com.mobileedu8.andelaschools.R;


public class StaffsRegisterFragment extends Fragment {

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



        initId(v);
        return v;
    }

    private void initId(View v) {

    }
}