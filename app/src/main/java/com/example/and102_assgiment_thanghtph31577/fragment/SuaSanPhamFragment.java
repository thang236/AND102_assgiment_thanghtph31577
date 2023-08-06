package com.example.and102_assgiment_thanghtph31577.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and102_assgiment_thanghtph31577.R;
import com.example.and102_assgiment_thanghtph31577.SanPhamDao;
import com.example.and102_assgiment_thanghtph31577.SanPhamModel;
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentSuaSanPhamBinding;

import java.util.ArrayList;


public class SuaSanPhamFragment extends Fragment {
    private int id;
    FragmentSuaSanPhamBinding binding;
    private SanPhamDao sanPhamDao;
    SanPhamModel sanPhamModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSuaSanPhamBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getInt("id");
        }
        sanPhamDao = new SanPhamDao(getContext());
        loadDataFormSQL();
        listener();
        return binding.getRoot();
    }

    private void loadDataFormSQL(){
        sanPhamModel = sanPhamDao.getSanPhamByMaSP(id);
        binding.edTenSP.setText(sanPhamModel.getTensp());
        binding.edGia.setText("" + sanPhamModel.getGiaban());
        binding.edSoLuong.setText("" + sanPhamModel.getSoluong());
    }
    private void listener(){
        binding.btnHoanTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenSP = binding.edTenSP.getText().toString().trim();
                String soLuong = binding.edSoLuong.getText().toString().trim();
                String gia = binding.edGia.getText().toString().trim();
                if (tenSP.isEmpty() || soLuong.isEmpty() || gia.isEmpty()){
                    Toast.makeText(getContext(), "Vui lòng nhập đủ các dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    SanPhamModel sanPhamUpdate = new SanPhamModel();
                    sanPhamUpdate.setMasp(id);
                    sanPhamUpdate.setTensp(tenSP);
                    sanPhamUpdate.setGiaban(Integer.parseInt(gia));
                    sanPhamUpdate.setSoluong(Integer.parseInt(soLuong));
                    sanPhamDao.updateSP(sanPhamUpdate);
                    Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new QLSanPhamFragment()).commit();
                }
            }
        });
    }
}