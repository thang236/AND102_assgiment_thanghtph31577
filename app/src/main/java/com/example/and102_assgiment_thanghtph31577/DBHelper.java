package com.example.and102_assgiment_thanghtph31577;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "asm", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qND = "create table NguoiDung(tendangnhap text primary key, matkhau text, hoten text)";
        db.execSQL(qND);

        String qSP = "create table SanPham(masp integer primary key autoincrement," +
                "tensp text, giaban integer, soluong integer)";
        db.execSQL(qSP);

        //Nạp dữ liệu cho table Products
        String data = "insert into SanPham values(1,'Bánh quy bơ LU Pháp',45000,10)," +
                "(2,'Snack mực lăn muối ớt',8000,52),(3,'Snack khoai tây Lays',12000,38)," +
                "(4,'Bánh gạo One One',30000,11),(5,'Kẹo sữa Chocolate',25000,30)";
        db.execSQL(data);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists NguoiDung");
        db.execSQL("drop table if exists SanPham");
    }
}