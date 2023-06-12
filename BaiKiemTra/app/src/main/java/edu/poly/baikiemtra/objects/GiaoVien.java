package edu.poly.baikiemtra.objects;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "giaovien")
public class GiaoVien implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String time;
    private String chuyennganh;

    public GiaoVien() {
    }

    public GiaoVien(String name, String time, String chuyennganh) {
        this.name = name;
        this.time = time;
        this.chuyennganh = chuyennganh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }
}
