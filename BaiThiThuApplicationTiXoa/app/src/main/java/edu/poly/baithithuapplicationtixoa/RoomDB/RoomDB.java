package edu.poly.baithithuapplicationtixoa.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.poly.baithithuapplicationtixoa.Dao.WorkDao;
import edu.poly.baithithuapplicationtixoa.objects.WorkObject;

@Database(entities = {WorkObject.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    public abstract WorkDao workDao();

    public static final String DB_NAME = "work.db";
    public static RoomDB instance;

    // Khởi tạo giá trị cho instance
    public static synchronized RoomDB getInstance(Context mContext) {
        if(instance == null) {
            instance = Room.databaseBuilder(mContext, RoomDB.class, DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    };

}
