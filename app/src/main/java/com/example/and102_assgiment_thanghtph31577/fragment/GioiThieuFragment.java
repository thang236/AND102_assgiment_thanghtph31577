package com.example.and102_assgiment_thanghtph31577.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and102_assgiment_thanghtph31577.R;
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentGioiThieuBinding;


public class GioiThieuFragment extends Fragment {
    FragmentGioiThieuBinding binding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGioiThieuBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment

        return binding.getRoot();
    }
}