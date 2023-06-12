package edu.poly.baitestmorongtixoa.objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "work")
public class Work implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String contend;
    private String time;

    public Work() {
    }

    public Work(String contend, String time) {
        this.contend = contend;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
