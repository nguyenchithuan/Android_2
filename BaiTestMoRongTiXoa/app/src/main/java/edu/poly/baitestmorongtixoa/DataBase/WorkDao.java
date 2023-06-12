package edu.poly.baitestmorongtixoa.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.poly.baitestmorongtixoa.objects.Work;

@Dao
public interface WorkDao {

    @Insert
    void inser(Work work);

    @Update
    void update(Work work);

    @Delete
    void delete(Work work);

    @Query("SELECT * FROM work")
    List<Work> selectAll();

    @Query("SELECT * FROM work WHERE contend = :contend")
    List<Work> selectOne(int contend);
}
