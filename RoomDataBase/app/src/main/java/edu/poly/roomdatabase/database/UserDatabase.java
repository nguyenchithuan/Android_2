package edu.poly.roomdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.poly.roomdatabase.objects.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static final String DB_NAME = "csdl.db";
    private static UserDatabase instance;

    public static synchronized UserDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, UserDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
}
