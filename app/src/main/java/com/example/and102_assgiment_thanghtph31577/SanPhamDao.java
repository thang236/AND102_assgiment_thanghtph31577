package com.example.and102_assgiment_thanghtph31577;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class SanPhamDao {
    private DBHelper dbHelper;
    public SanPhamDao(Context context) {
        this.dbHelper = new DBHelper(context);
    }



    public ArrayList<SanPhamModel> getListSP() {

        ArrayList<SanPhamModel> sanPhamModelArrayList = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Log.d("TAG", "getListSP: " + sanPhamModelArrayList.size());
        database.beginTransaction();

        try {
            Cursor cursor = database.rawQuery("SELECT * FROM SanPham", null);
            Log.d("TAG", "getListToDo: chưa get cout: " + cursor.getCount());

            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                Log.d("TAG", "getListToDo: chưa get if: " + cursor.getCount());

                do {
                    sanPhamModelArrayList.add(new SanPhamModel(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getDouble(2),
                            cursor.getInt(3)));
                } while (cursor.moveToNext());
                database.setTransactionSuccessful();


            }
        } catch (Exception e) {
            Log.e("zzzzz", "getListToDo: " + e.getMessage());
        } finally {
            database.endTransaction();
            database.close();
        }
        return sanPhamModelArrayList;

    }
    public boolean removeSP(int id){
        SQLiteDatabase sqLiteDatabase =dbHelper.getWritableDatabase();
        int row = sqLiteDatabase.delete("SanPham", "id = ?", new String[]{String.valueOf(id)});
        return  row!=-1;
    }

    public boolean addSP(SanPhamModel sanPhamModel) {
        Log.d("zzzz", "addToDo: chưa add" + getListSP().size());

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();

        ContentValues values = new ContentValues();

        values.put("tensp", sanPhamModel.getTensp());
        values.put("giaban", sanPhamModel.getGiaban());
        values.put("soluong", sanPhamModel.getSoluong());
        database.setTransactionSuccessful();
        database.endTransaction();

        long check = database.insert("TODO", null, values);



        return check != -1;
    }





}
