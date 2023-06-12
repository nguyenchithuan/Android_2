package edu.poly.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.assignment.DTO.LoaiThu;
import edu.poly.assignment.DbHelper.DbHelper;

public class DaoLoaiThu {
    SQLiteDatabase db;

    public DaoLoaiThu(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<LoaiThu> selectAll() {
        ArrayList<LoaiThu> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM loaithu", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                LoaiThu khoanThu = new LoaiThu();

                khoanThu.setStt(cursor.getInt(0));
                khoanThu.setKhoanThu(cursor.getString(1));
                khoanThu.setLoaiThu(cursor.getString(2));
                khoanThu.setThoiGian(cursor.getString(3));

                list.add(khoanThu);
                cursor.moveToNext();
            }
        }

        return list;
    }

    public LoaiThu selectOne(int stt) {
        LoaiThu khoanThu = new LoaiThu();

        Cursor cursor = db.rawQuery("SELECT * FROM loaithu WHERE stt = ?", new String[]{stt + ""});

        if(cursor.moveToFirst()) {
            khoanThu.setStt(cursor.getInt(0));
            khoanThu.setKhoanThu(cursor.getString(1));
            khoanThu.setLoaiThu(cursor.getString(2));
            khoanThu.setThoiGian(cursor.getString(3));
        }

        return khoanThu;
    }

    public long insert(LoaiThu khoanThu) {
        ContentValues values = new ContentValues();
        values.put("khoanThu", khoanThu.getKhoanThu());
        values.put("loaiThu", khoanThu.getLoaiThu());
        values.put("thoiGian", khoanThu.getThoiGian());
        return db.insert("loaithu", null, values);
    }

    public int update(LoaiThu khoanThu) {
        ContentValues values = new ContentValues();
        values.put("khoanThu", khoanThu.getKhoanThu());
        values.put("loaiThu", khoanThu.getLoaiThu());
        values.put("thoiGian", khoanThu.getThoiGian());
        return db.update("loaithu", values, "stt = ?", new String[] {khoanThu.getStt() + ""});
    }

    public int delete(int stt) {
        return db.delete("loaithu",  "stt = ?", new String[] {stt + ""});
    }
}





