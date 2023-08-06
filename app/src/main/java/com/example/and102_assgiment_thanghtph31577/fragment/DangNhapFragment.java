package com.example.and102_assgiment_thanghtph31577.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and102_assgiment_thanghtph31577.MainActivity;
import com.example.and102_assgiment_thanghtph31577.R;
import com.example.and102_assgiment_thanghtph31577.SanPhamDao;
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentDangNhapBinding;


public class DangNhapFragment extends Fragment {
    FragmentDangNhapBinding binding;
    String edUsername, edPassword;
    SanPhamDao sanPhamDao;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDangNhapBinding.inflate(inflater, container, false);
        sanPhamDao = new SanPhamDao(getContext());
        listener();

        return binding.getRoot();
    }

    private void listener() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new DangKyFragment()).addToBackStack(null).commit();
            }
        });
    }
    private void validate() {
        edUsername = binding.edUsername.getText().toString().trim();
        edPassword = binding.edPassword.getText().toString().trim();
        if (edUsername.isEmpty() || edPassword.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhập đủ các trường", Toast.LENGTH_SHORT).show();
        }else if (sanPhamDao.login(edUsername, edPassword) == 1) {
            Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }
}