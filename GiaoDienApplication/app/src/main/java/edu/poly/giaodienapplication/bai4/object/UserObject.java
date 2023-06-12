package edu.poly.giaodienapplication.bai4.object;

public class UserObject {
    private String name;
    private int img_avata;

    public UserObject() {
    }

    public UserObject(String name, int img_avata) {
        this.name = name;
        this.img_avata = img_avata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_avata() {
        return img_avata;
    }

    public void setImg_avata(int img_avata) {
        this.img_avata = img_avata;
    }
}
