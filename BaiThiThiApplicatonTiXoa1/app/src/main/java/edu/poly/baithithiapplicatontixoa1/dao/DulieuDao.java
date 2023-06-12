package edu.poly.baithithiapplicatontixoa1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.baithithiapplicatontixoa1.DbHelper.DbHelper;
import edu.poly.baithithiapplicatontixoa1.objects.DuLieu;

public class DulieuDao {

    SQLiteDatabase db;

    public DulieuDao(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<DuLieu> seletionAll() {
        ArrayList<DuLieu> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(" SELECT * FROM  bangdulieu", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                DuLieu duLieu = new DuLieu();
                duLieu.setId(cursor.getInt(0));
                duLieu.setNoiDung(cursor.getString(1));
                duLieu.setThoiGian(cursor.getString(2));

                list.add(duLieu);

                cursor.moveToNext();
            }
        }

        return list;
    }

    public DuLieu selectOne(int id) {
        DuLieu duLieu = new DuLieu();

        Cursor cursor = db.rawQuery(" SELECT * FROM  bangdulieu WHERE id = ?", new String[] { id + "" });
        if(cursor.moveToFirst()) {
            duLieu.setId(cursor.getInt(0));
            duLieu.setNoiDung(cursor.getString(1));
            duLieu.setThoiGian(cursor.getString(2));
        }
        return duLieu;
    }

    public long insert(DuLieu duLieu) {
        ContentValues values = new ContentValues();
        values.put("noidung", duLieu.getNoiDung());
        values.put("thoigian", duLieu.getThoiGian());
        return db.insert("bangdulieu", null, values);
    }

    public int update(DuLieu duLieu) {
        ContentValues values = new ContentValues();
        values.put("noidung", duLieu.getNoiDung());
        values.put("thoigian", duLieu.getThoiGian());
        return db.update("bangdulieu", values, "id = ?", new String[] {duLieu.getId() + ""});
    }

    public int delete(DuLieu duLieu) {
        return db.delete("bangdulieu", "id = ?", new String[] {duLieu.getId() + ""});
    }
}
