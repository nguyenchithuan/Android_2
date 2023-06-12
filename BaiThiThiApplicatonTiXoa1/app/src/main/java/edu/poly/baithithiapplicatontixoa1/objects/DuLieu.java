package edu.poly.baithithiapplicatontixoa1.objects;

import java.io.Serializable;

public class DuLieu implements Serializable {
    private int id;
    private String noiDung;
    private String thoiGian;

    public DuLieu() {
    }

    public DuLieu(String noiDung, String thoiGian) {
        this.noiDung = noiDung;
        this.thoiGian = thoiGian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
