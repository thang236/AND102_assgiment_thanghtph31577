package com.example.and102_assgiment_thanghtph31577;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.and102_assgiment_thanghtph31577.databinding.ActivityDangNhapBinding;
import com.example.and102_assgiment_thanghtph31577.fragment.DangNhapFragment;

public class DangNhapActivity extends AppCompatActivity {
    ActivityDangNhapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDangNhapBinding.inflate(getLayoutInflater());

        getSupportFragmentManager().beginTransaction().add(R.id.container, new DangNhapFragment()).commit();
        setContentView(binding.getRoot());
    }
}