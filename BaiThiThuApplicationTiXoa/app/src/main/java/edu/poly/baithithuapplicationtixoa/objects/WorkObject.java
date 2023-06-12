package edu.poly.baithithuapplicationtixoa.objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "work")
public class WorkObject implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "contend")
    private String contend;
    @ColumnInfo(name = "time")
    private String time;

    public WorkObject() {
    }

    public WorkObject(String contend, String time) {
        this.contend = contend;
        this.time = time;
    }

    public String getContend() {
        return contend;
    }

    public void setContend(String contend) {
        this.contend = contend;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
