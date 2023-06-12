package edu.poly.assignment.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.poly.assignment.DTO.KhoanChi;
import edu.poly.assignment.DbHelper.DbHelper;

public class DaoKhoanChi {

    SQLiteDatabase db;

    public DaoKhoanChi(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<KhoanChi> selectAll() {
        ArrayList<KhoanChi> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM khoanchi", null);

        if(cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                KhoanChi khoanChi = new KhoanChi();

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


    public KhoanChi selectOne(int stt) {
        KhoanChi khoanChi = new KhoanChi();

        Cursor cursor = db.rawQuery("SELECT * FROM khoanchi WHERE stt = ?", new String[] {stt + ""});

        if(cursor.moveToFirst()) {
            khoanChi.setStt(cursor.getInt(0));
            khoanChi.setKhoanChi(cursor.getString(1));
            khoanChi.setLoaiChi(cursor.getString(2));
            khoanChi.setThoiGian(cursor.getString(3));
        }

        return  khoanChi;
    }

    public long insert(KhoanChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("khoanChi", khoanChi.getKhoanChi());
        values.put("loaiChi", khoanChi.getLoaiChi());
        values.put("thoigian", khoanChi.getThoiGian());

        return db.insert("khoanchi", null, values);
    }

    public int update(KhoanChi khoanChi) {
        ContentValues values = new ContentValues();
        values.put("khoanChi", khoanChi.getKhoanChi());
        values.put("loaiChi", khoanChi.getLoaiChi());
        values.put("thoigian", khoanChi.getThoiGian());

        return db.update("khoanchi", values, "stt = ?", new String[] {khoanChi.getStt() + ""});
    }

    public int delete(int stt) {
        return db.delete("khoanchi", "stt = ?", new String[] {stt + ""});
    }

}
