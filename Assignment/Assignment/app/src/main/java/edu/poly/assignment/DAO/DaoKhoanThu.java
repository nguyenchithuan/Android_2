package edu.poly.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.assignment.DTO.KhoanThu;
import edu.poly.assignment.DbHelper.DbHelper;

public class DaoKhoanThu {
    SQLiteDatabase db;

    public DaoKhoanThu(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<KhoanThu> selectAll() {
        ArrayList<KhoanThu> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM khoanThu", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                KhoanThu khoanThu = new KhoanThu();

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

    public KhoanThu selectOne(int stt) {
        KhoanThu khoanThu = new KhoanThu();

        Cursor cursor = db.rawQuery("SELECT * FROM khoanthu WHERE stt = ?", new String[]{stt + ""});

        if(cursor.moveToFirst()) {
            khoanThu.setStt(cursor.getInt(0));
            khoanThu.setKhoanThu(cursor.getString(1));
            khoanThu.setLoaiThu(cursor.getString(2));
            khoanThu.setThoiGian(cursor.getString(3));
        }

        return khoanThu;
    }

    public long insert(KhoanThu khoanThu) {
        ContentValues values = new ContentValues();
        values.put("khoanThu", khoanThu.getKhoanThu());
        values.put("loaiThu", khoanThu.getLoaiThu());
        values.put("thoiGian", khoanThu.getThoiGian());
        return db.insert("khoanthu", null, values);
    }

    public int update(KhoanThu khoanThu) {
        ContentValues values = new ContentValues();
        values.put("khoanThu", khoanThu.getKhoanThu());
        values.put("loaiThu", khoanThu.getLoaiThu());
        values.put("thoiGian", khoanThu.getThoiGian());
        return db.update("khoanthu", values, "stt = ?", new String[] {khoanThu.getStt() + ""});
    }

    public int delete(int stt) {
        return db.delete("khoanthu",  "stt = ?", new String[] {stt + ""});
    }
}





