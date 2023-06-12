package edu.poly.baikiemtra.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.poly.baikiemtra.objects.GiaoVien;

@Database(entities = {GiaoVien.class}, version = 1)
public abstract class GVDatabase extends RoomDatabase {
    private static final String DB_NAME = "database.db";
    private static GVDatabase instance;

    public static synchronized GVDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, GVDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract GiaoVienDao giaoVienDao();
}
