package com.example.and102_assgiment_thanghtph31577;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "ASMDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //add table
        String nguoiDung = "CREATE TABLE NguoiDung(tendangnhap TEXT PRIMARY KEY, "+
                "matkhau TEXT, hoten TEXT)";
        sqLiteDatabase.execSQL(nguoiDung);

        String sanPham = "CREATE TABLE SanPham(masp INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "tensp TEXT, giaban DOUBLE,soluong INTEGER )";
        sqLiteDatabase.execSQL(sanPham);

        //add data
        String dataNguoiDung = "INSERT INTO NguoiDung VALUES ('admin', '123456', 'ADMIN')";
        sqLiteDatabase.execSQL(dataNguoiDung);
        String dataSanPham = "INSERT INTO SanPham VALUES ('banh quy', 3000.0, 5)";
        sqLiteDatabase.execSQL(dataSanPham);





    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i != i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NguoiDung");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(sqLiteDatabase);
        }
    }
}
