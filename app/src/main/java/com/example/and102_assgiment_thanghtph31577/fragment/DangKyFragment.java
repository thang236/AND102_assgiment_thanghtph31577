package com.example.and102_assgiment_thanghtph31577.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and102_assgiment_thanghtph31577.R;
import com.example.and102_assgiment_thanghtph31577.SanPhamDao;
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentDangKyBinding;


public class DangKyFragment extends Fragment {
    FragmentDangKyBinding binding;
    String  edUser,edPass1, edPass2, edName;
    SanPhamDao sanPhamDao;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDangKyBinding.inflate(inflater, container, false);
        sanPhamDao = new  SanPhamDao(getContext());
        listener();


        return binding.getRoot();
    }
    private void listener() {
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }
    private void validate() {
        edName = binding.edName.getText().toString().trim();
        edPass1 = binding.edPassword.getText().toString().trim();
        edPass2 = binding.edPassword2.getText().toString().trim();
        edUser  = binding.edUsername.getText().toString().trim();
        if (edUser.isEmpty() || edPass1.isEmpty() || edPass2.isEmpty() || edName.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhâ đủ các trường", Toast.LENGTH_SHORT).show();
        } else if (!edPass1.equals(edPass2)){
            Toast.makeText(getContext(), "Vui lòng nhập lại đúng mật khẩu", Toast.LENGTH_SHORT).show();
        }else {
            boolean check = sanPhamDao.checkUsername(edUser);
            if (check) {
                binding.edUsername.setError("Tên đang nhập đã có người sử dụng");
            }else {
                sanPhamDao.register(edUser, edPass1, edName);
                Toast.makeText(getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().popBackStack();
            }
        }
    }

}