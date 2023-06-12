package edu.poly.adapter.Model;

public class UngDung {
    private int imgAnh;
    private String name;

    public UngDung() {
    }

    public UngDung(int imgAnh, String name) {
        this.imgAnh = imgAnh;
        this.name = name;
    }

    public int getImgAnh() {
        return imgAnh;
    }

    public void setImgAnh(int imgAnh) {
        this.imgAnh = imgAnh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
