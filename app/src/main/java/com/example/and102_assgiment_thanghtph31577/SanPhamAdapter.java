package com.example.and102_assgiment_thanghtph31577;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and102_assgiment_thanghtph31577.databinding.DialogChucnangBinding;
import com.example.and102_assgiment_thanghtph31577.databinding.ItemRcvBinding;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder> {
    Context context;
    ArrayList<SanPhamModel> sanPhamModelArrayList;
    ChucNanginterfaceSanPham chucNanginterfaceSanPham;

    public SanPhamAdapter(Context context, ArrayList<SanPhamModel> sanPhamModelArrayList, ChucNanginterfaceSanPham chucNanginterfaceSanPham) {
        this.context = context;
        this.sanPhamModelArrayList = sanPhamModelArrayList;
        this.chucNanginterfaceSanPham = chucNanginterfaceSanPham;
    }
    public interface ChucNanginterfaceSanPham {
        void update(int id);
        void delete(int id);
        void xemChiTiet(int id);
    }

    @NonNull
    @Override
    public SanPhamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRcvBinding binding = ItemRcvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamAdapter.ViewHolder holder, int position) {
    SanPhamModel object = sanPhamModelArrayList.get(position);

    holder.binding.tvTenSP.setText(object.getTensp());
    holder.binding.tvGiaBan.setText("" + object.getGiaban());
    holder.binding.tvSoLuong.setText("" + object.getSoluong());
    holder.binding.btnLuaChon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openDialogChucNang(object, holder);
        }
    });
    }

    @Override
    public int getItemCount() {
        return sanPhamModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRcvBinding binding;
        public ViewHolder(@NonNull ItemRcvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    private void openDialogChucNang(SanPhamModel object, SanPhamAdapter.ViewHolder holder) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        DialogChucnangBinding binding = DialogChucnangBinding.inflate(inflater);
        View view = binding.getRoot();
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        binding.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chucNanginterfaceSanPham.update(object.getMasp());
                dialog.dismiss();

            }
        });
        binding.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chucNanginterfaceSanPham.delete(object.getMasp());
                dialog.dismiss();
            }
        });
        binding.btnXemchiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chucNanginterfaceSanPham.xemChiTiet(object.getMasp());
                dialog.dismiss();

            }
        });
    }
}
