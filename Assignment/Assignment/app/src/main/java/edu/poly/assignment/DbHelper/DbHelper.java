package edu.poly.assignment.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Dulieu";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE khoanthu(stt INTEGER, khoanThu TEXT NOT NULL, loaiThu TEXT NOT NULL, thoiGian TEXT, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('10000 vnđ', 'Xúc Xích', '20-10-2017')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('20000 vnđ', 'Bánh Mỳ', '05-11-2015')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('54000 vnđ', 'Kem', '22-01-2016')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('6012 vnđ', 'Bim bim', '05-11-2015')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('72000 vnđ', 'Xiên', '22-01-2018')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('12000 vnđ', 'Mỳ Tôm', '20-10-2019')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('98000 vnđ', 'Tiền Học', '05-11-2020')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('1000 vnđ', 'Cà Phê', '22-01-2021')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('2000 vnđ', 'Trà Sữa', '22-01-2017')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('78000 vnđ', 'Pizza', '22-01-2018')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('24000 vnđ', 'Máy lạnh', '20-10-2019')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('87000 vnđ', 'Điều Hòa', '05-11-2020')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('12000 vnđ', 'Cà Phê', '22-01-2021')";
        db.execSQL(sql);

        sql = "INSERT INTO khoanthu(khoanThu, loaiThu, thoiGian) VALUES('2000 vnđ', 'Trà Sữa', '22-01-2017')";
        db.execSQL(sql);




        String sql1 = "CREATE TABLE khoanchi(stt INTEGER, khoanChi TEXT NOT NULL, loaiChi TEXT NOT NULL, thoigian TEXT, PRIMARY KEY(stt AUTOINCREMENT))";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('12000 vnđ', 'Đi Chơi', '22-01-2015')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('2000 vnđ', 'Dầu gội', '04-12-2021')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('6000 vnđ', 'Bột Giặt', '01-01-2016')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('10000 vnđ', 'Tiền Học Phí', '22-01-2017')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('220000 vnđ', 'Bánh Mỳ', '04-12-2019')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('15000 vnđ', 'Bút Chì', '01-01-2020')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('24000 vnđ', 'Điều hòa', '22-01-2018')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('89000 vnđ', 'Cửa Sổ', '04-12-2021')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('16000 vnđ', 'Loa Đài', '01-01-2016')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('502000 vnđ', 'Bình Nước', '22-01-2017')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('120000 vnđ', 'Ô Tô', '04-12-2019')";
        db.execSQL(sql1);

        sql1 = "INSERT INTO khoanchi(khoanChi, loaiChi, thoigian) VALUES('15000 vnđ', 'Xe máy', '01-01-2020')";
        db.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS khoanthu";
        db.execSQL(sql);
        sql = "DROP TABLE IF EXISTS khoanchi";
        db.execSQL(sql);
        onCreate(db);
    }
}
