package com.example.and102_assgiment_thanghtph31577;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class SanPhamDao {
    private final DBHelper dbHelper;
    public SanPhamDao(Context context) {
        dbHelper = new DBHelper(context);
    }



    public ArrayList<SanPhamModel> getListSanPham(){
        //tạo một danh sách để add dữ liệu vào SanPham
        ArrayList<SanPhamModel> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.beginTransaction();
        try {
            Cursor c = database.rawQuery("select * from SanPham",null);
            if (c.getCount() > 0){
                c.moveToFirst();
                do {
                    list.add(new SanPhamModel(c.getInt(0),
                            c.getString(1),
                            c.getInt(2),
                            c.getInt(3)));
                }while (c.moveToNext());
                database.setTransactionSuccessful();
            }
        }catch (Exception e){
            Log.e("Error", "getListSanPham: " + e.getMessage());
        }finally {
            database.endTransaction();
        }
        return list;
    }
    public SanPhamModel getSanPhamByMaSP(int masp) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query("SanPham", new String[]{"masp", "tensp", "giaban", "soluong"}, "masp = ?",
                new String[]{String.valueOf(masp)},
                null, null, null
        );

        if (cursor.moveToFirst()) {
            int maspIndex = cursor.getColumnIndex("masp");
            int tenspIndex = cursor.getColumnIndex("tensp");
            int giabanIndex = cursor.getColumnIndex("giaban");
            int soluongIndex = cursor.getColumnIndex("soluong");

            int maspValue = cursor.getInt(maspIndex);
            String tenspValue = cursor.getString(tenspIndex);
            int giabanValue = cursor.getInt(giabanIndex);
            int soluongValue = cursor.getInt(soluongIndex);

            return new SanPhamModel(maspValue, tenspValue, giabanValue, soluongValue);
        }

        // Không tìm thấy sản phẩm với masp tương ứng
        return null;
    }

    public boolean addSP(SanPhamModel sanPhamModel) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();

        ContentValues values = new ContentValues();

        values.put("tensp", sanPhamModel.getTensp());
        values.put("giaban", sanPhamModel.getGiaban());
        values.put("soluong", sanPhamModel.getSoluong());
        database.setTransactionSuccessful();
        database.endTransaction();

        long check = database.insert("SanPham", null, values);



        return check != -1;
    }
    public boolean removeSP(int id){
        SQLiteDatabase sqLiteDatabase =dbHelper.getWritableDatabase();
        int row = sqLiteDatabase.delete("SanPham", "masp = ?", new String[]{String.valueOf(id)});
        return  row!=-1;
    }
    public  boolean updateSP ( SanPhamModel sanPhamModel ){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tensp", sanPhamModel.getTensp());
        values.put("giaban", sanPhamModel.getGiaban());
        values.put("soluong", sanPhamModel.getSoluong());
        int check = database.update("SanPham", values, "masp = ?", new String[]{String.valueOf(sanPhamModel.getMasp())});
        return  check!=-1;
    }

    public boolean checkUsername(String tenDangNhap){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("select * from NguoiDung where tendangnhap=?",
                new String[]{tenDangNhap});
        if (c.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }

    public void register(String tenDangNhap, String matKhau, String hoTen){
        ContentValues cv = new ContentValues();
        cv.put("tendangnhap",tenDangNhap);
        cv.put("matkhau",matKhau);
        cv.put("hoten",hoTen);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("NguoiDung",null,cv);
        db.close();
    }

    public int login(String tenDangNhap, String matKhau){
        int result = 0;
        String str[] = new String[2];
        str[0] = tenDangNhap;
        str[1] = matKhau;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from NguoiDung where tendangnhap=? and matkhau=?",str);
        if (c.moveToNext()){
            result = 1;
        }
        return result;
    }








}
