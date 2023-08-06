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
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentThemSanPhamBinding;


public class ThemSanPhamFragment extends Fragment {
    FragmentThemSanPhamBinding binding;
    String tenSP = "", giaSP ="", soLuong = "";
    SanPhamDao sanPhamDao;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sanPhamDao = new SanPhamDao(getContext());
        binding = FragmentThemSanPhamBinding.inflate(inflater,container, false);
        listener();

        return binding.getRoot();
    }
    private void listener() {
        binding.btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenSP = binding.edTenSP.getText().toString().trim();
                giaSP = binding.edGia.getText().toString().trim();
                soLuong = binding.edSoLuong.getText().toString().trim();
                if (tenSP.isEmpty() || giaSP.isEmpty() || soLuong.isEmpty()) {
                    Toast.makeText(getContext(), "Hãy điền đủ tất cả các trường", Toast.LENGTH_SHORT).show();
                }
                else {
                    savetoSQL();
                }
            }
        });
    }
    private void savetoSQL() {
        SanPhamModel sanPhamModel = new SanPhamModel();
        sanPhamModel.setTensp(binding.edTenSP.getText().toString().trim());
        sanPhamModel.setGiaban(Integer.parseInt(binding.edGia.getText().toString().trim()));
        sanPhamModel.setSoluong(Integer.parseInt(binding.edSoLuong.getText().toString().trim()));
        sanPhamDao.addSP(sanPhamModel);
        Toast.makeText(getContext(), "Thêm mới thành công", Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new QLSanPhamFragment()).commit();
    }
}