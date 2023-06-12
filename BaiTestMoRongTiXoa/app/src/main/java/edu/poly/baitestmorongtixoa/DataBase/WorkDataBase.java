package edu.poly.baitestmorongtixoa.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.poly.baitestmorongtixoa.objects.Work;

@Database(entities = {Work.class}, version = 1)
public abstract class WorkDataBase extends RoomDatabase {
    private static final String DB_NAME = "dulieu.db";
    private static WorkDataBase instance;

    public static synchronized WorkDataBase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, WorkDataBase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract WorkDao workDao();
}
