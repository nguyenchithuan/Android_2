package edu.poly.giaodienapplication.Bai3.listview.data;

public class DataLv {
    private int img;
    private String name;
    private int age;

    public DataLv() {
    }

    public DataLv(int img, String name, int age) {
        this.img = img;
        this.name = name;
        this.age = age;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
