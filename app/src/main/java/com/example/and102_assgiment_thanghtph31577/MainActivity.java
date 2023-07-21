package com.example.and102_assgiment_thanghtph31577;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.and102_assgiment_thanghtph31577.databinding.ActivityMainBinding;
import com.example.and102_assgiment_thanghtph31577.fragment.CaiDatFragment;
import com.example.and102_assgiment_thanghtph31577.fragment.GioiThieuFragment;
import com.example.and102_assgiment_thanghtph31577.fragment.QLSanPhamFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setNavi();


        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new GioiThieuFragment()).commit();
        setTitle("Giới thiệu");

    }
    private void setNavi(){
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                MainActivity.this, binding.drawerLayout, binding.toolbar, 0,0
        );
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        binding.drawerLayout.addDrawerListener(drawerToggle);
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new Fragment();

                if (item.getItemId() == R.id.sanPham){
                    setTitle("Quản lý sản phẩm");
                    fragment = new QLSanPhamFragment();

                } else if (item.getItemId() == R.id.gioiThieu) {
                    setTitle("Giới thiệu");
                    fragment = new GioiThieuFragment();
                }else if (item.getItemId() == R.id.caiDat){
                    setTitle("Cài đặt");
                    fragment = new CaiDatFragment();
                }else {
                    Toast.makeText(getApplicationContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
                binding.drawerLayout.close();
                return true;
            }
        });
    }
}