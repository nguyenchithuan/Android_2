package edu.poly.roomdatabase.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.poly.roomdatabase.objects.User;

@Dao
public interface UserDao {

    @Insert
    void inser(User user);

    @Query("SELECT * FROM user")
    List<User> selectAll();

    @Query("SELECT * FROM user WHERE username = :username")
    List<User> checkUser(String username);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user")
    void deleteAll();
}
