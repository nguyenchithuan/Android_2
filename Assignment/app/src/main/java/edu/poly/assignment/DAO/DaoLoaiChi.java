package edu.poly.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.assignment.DTO.LoaiChi;
import edu.poly.assignment.DbHelper.DbHelper;

public class DaoLoaiChi {

    SQLiteDatabase db;

    public DaoLoaiChi(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<LoaiChi> selectAll() {
        ArrayList<LoaiChi> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM loaichi", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                LoaiChi khoanChi = new LoaiChi();

                khoanChi.setStt(cursor.getInt(0));
                khoanChi.setKhoanChi(cursor.getString(1));
                khoanChi.setLoaiChi(cursor.getString(2));
                khoanChi.setThoiGian(cursor.getString(3));

                list.add(khoanChi);

                cursor.moveToNext();

            }
        }

        return  list;
    }


    public LoaiChi selectOne(int stt) {
        LoaiChi khoanChi = new LoaiChi();

        Cursor cursor = db.rawQuery("SELECT * FROM loaichi WHERE stt = ?", new String[] {stt + ""});

        if(cursor.moveToFirst()) {
            khoanChi.setStt(cursor.getInt(0));
            khoanChi.setKhoanChi(cursor.getString(1));
            khoanChi.setLoaiChi(cursor.getString(2));
            khoanChi.setThoiGian(cursor.getString(3));
        }

        return  khoanChi;
    }

    public long insert(LoaiChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("khoanChi", khoanChi.getKhoanChi());
        values.put("loaiChi", khoanChi.getLoaiChi());
        values.put("thoigian", khoanChi.getThoiGian());

        return db.insert("loaichi", null, values);
    }

    public int update(LoaiChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("khoanChi", khoanChi.getKhoanChi());
        values.put("loaiChi", khoanChi.getLoaiChi());
        values.put("thoigian", khoanChi.getThoiGian());

        return db.update("loaichi", values, "stt = ?", new String[] {khoanChi.getStt() + ""});
    }

    public int delete(int stt) {
        return db.delete("loaichi", "stt = ?", new String[] {stt + ""});
    }

}
