package edu.poly.baithithuapplicationtixoa.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import edu.poly.baithithuapplicationtixoa.objects.WorkObject;

@Dao
public interface WorkDao {

    @Query("SELECT * FROM work")
    List<WorkObject> selectAll();

    @Query("SELECT * FROM work WHERE id = :ID")
    WorkObject selectOne(int ID);

    @Insert
    void insert(WorkObject object);

    @Update
    void update(WorkObject object);

    @Delete
    void delete(WorkObject object);

}
