package com.example.and102_assgiment_thanghtph31577.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and102_assgiment_thanghtph31577.MainActivity;
import com.example.and102_assgiment_thanghtph31577.R;
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentDangNhapBinding;


public class DangNhapFragment extends Fragment {
    FragmentDangNhapBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDangNhapBinding.inflate(inflater, container, false);
        listener();

        return binding.getRoot();
    }

    private void listener() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}