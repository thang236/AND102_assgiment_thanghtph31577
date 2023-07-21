package com.example.and102_assgiment_thanghtph31577.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.and102_assgiment_thanghtph31577.R;
import com.example.and102_assgiment_thanghtph31577.SanPhamAdapter;
import com.example.and102_assgiment_thanghtph31577.SanPhamDao;
import com.example.and102_assgiment_thanghtph31577.SanPhamModel;
import com.example.and102_assgiment_thanghtph31577.databinding.FragmentQLSanrPhamBinding;

import java.util.ArrayList;


public class QLSanPhamFragment extends Fragment implements SanPhamAdapter.ChucNanginterfaceSanPham {
    FragmentQLSanrPhamBinding binding;
    ArrayList<SanPhamModel> sanPhamModelArrayList;
    SanPhamAdapter adapter;
    SanPhamAdapter.ChucNanginterfaceSanPham chucNanginterfaceSanPham;
    SanPhamDao sanPhamDao = new SanPhamDao(getContext());



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQLSanrPhamBinding.inflate(inflater, container, false);
        loadDataFromSQL();
        listener();

        // Inflate the layout for this fragment



        return binding.getRoot();
    }
    public void loadDataFromSQL() {
        sanPhamModelArrayList = sanPhamDao.getListSP();
        Log.d("zzzzzzz", "loadDataFromSQL: " + sanPhamModelArrayList.size());
//        ArrayList<SanPhamModel> abcd = new ArrayList<>();
//        SanPhamModel obj = new SanPhamModel(1,"thang",1000, 10);
//        abcd.add(obj);
        adapter = new SanPhamAdapter(getContext(), sanPhamModelArrayList, chucNanginterfaceSanPham);
        binding.rcv.setAdapter(adapter);
    }
    public void listener(){
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ThemSanPhamFragment()).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public void update(String id) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SuaSanPhamFragment()).addToBackStack(null).commit();
    }

    @Override
    public void delete(String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Bạn có chắc muốn xóa không ?");
        builder.setPositiveButton("chắc chắn", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Xoá thành công", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });
        builder.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Bạn chọn không xóa", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();

            }
        });


        builder.show();


    }

    @Override
    public void xemChiTiet(String id) {
        Toast.makeText(getContext(), "tính năng đang được phát triển", Toast.LENGTH_SHORT).show();

    }
}