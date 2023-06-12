package edu.poly.baikiemtra.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.poly.baikiemtra.objects.GiaoVien;

@Dao
public interface GiaoVienDao {

    @Insert
    void insert(GiaoVien giaoVien);

    @Update
    void update(GiaoVien giaoVien);

    @Delete
    void delete(GiaoVien giaoVien);


    @Query("SELECT * FROM giaovien")
    List<GiaoVien> selectAll();

}
