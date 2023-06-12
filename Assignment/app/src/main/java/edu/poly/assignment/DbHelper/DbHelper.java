package edu.poly.assignment.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Dulieu";
    private static final int DB_VERSION = 7;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql2 = "CREATE TABLE khoanthu(stt INTEGER, khoanThu TEXT NOT NULL, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql2);

        sql2 = "INSERT INTO khoanthu(khoanThu) VALUES('Bài tập')";
        db.execSQL(sql2);

        sql2 = "INSERT INTO khoanthu(khoanThu) VALUES('Sách vở')";
        db.execSQL(sql2);

        sql2 = "INSERT INTO khoanthu(khoanThu) VALUES('Bút chì')";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE khoanchi(stt INTEGER, khoanChi TEXT NOT NULL, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql3);

        sql3 = "INSERT INTO khoanchi(khoanChi) VALUES('Bánh mỳ')";
        db.execSQL(sql3);

        sql3 = "INSERT INTO khoanchi(khoanChi) VALUES('Mỳ tôm')";
        db.execSQL(sql3);

        sql3 = "INSERT INTO khoanchi(khoanChi) VALUES('Bánh bao')";
        db.execSQL(sql3);

        String sql = "CREATE TABLE loaithu(stt INTEGER, khoanThu TEXT NOT NULL, loaiThu TEXT NOT NULL, thoiGian TEXT, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO loaithu(khoanThu, loaiThu, thoiGian) VALUES('Xúc Xích', 'Bài tập', '20-10-2017')";
        db.execSQL(sql);

        sql = "INSERT INTO loaithu(khoanThu, loaiThu, thoiGian) VALUES('Bánh Mỳ', 'Sách vở', '05-11-2015')";
        db.execSQL(sql);

        sql = "INSERT INTO loaithu(khoanThu, loaiThu, thoiGian) VALUES('Kem', 'Bút chì', '22-01-2016')";
        db.execSQL(sql);

        sql = "INSERT INTO loaithu(khoanThu, loaiThu, thoiGian) VALUES('Bim bim', 'Sách vở', '05-11-2015')";
        db.execSQL(sql);



        String sql1 = "CREATE TABLE loaichi(stt INTEGER, khoanChi TEXT NOT NULL, loaiChi TEXT NOT NULL, thoigian TEXT, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql1);

        sql1 = "INSERT INTO loaichi(khoanChi, loaiChi, thoigian) VALUES('Đi Chơi', 'Bánh mỳ', '22-01-2015')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO loaichi(khoanChi, loaiChi, thoigian) VALUES('Dầu gội', 'Mỳ tôm', '04-12-2021')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO loaichi(khoanChi, loaiChi, thoigian) VALUES('Bột Giặt', 'Bánh mỳ', '01-01-2016')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO loaichi(khoanChi, loaiChi, thoigian) VALUES('Tiền Học Phí', 'Bánh bao', '22-01-2017')";
        db.execSQL(sql1);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS loaithu";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS loaichi";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS khoanthu";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS khoanchi";
        db.execSQL(sql);
        onCreate(db);
    }

}
