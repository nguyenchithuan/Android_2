package edu.poly.baithithiapplicatontixoa1.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "dulieu";
    public static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE bangdulieu(id INTEGER, noidung TEXT NOT NULL, thoigian TEXT NOT NULL, PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO bangdulieu(noidung, thoigian) VALUES('a', 'a')";
        db.execSQL(sql);
        sql = "INSERT INTO bangdulieu(noidung, thoigian) VALUES('b', 'b')";
        db.execSQL(sql);
        sql = "INSERT INTO bangdulieu(noidung, thoigian) VALUES('c', 'c')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
