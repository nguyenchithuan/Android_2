package edu.poly.giaodienapplication.bai2.Model;

public class SanPham {
    private int anh;
    private String tenUngDung;

    public SanPham() {
    }

    public SanPham(int anh, String tenUngDung) {
        this.anh = anh;
        this.tenUngDung = tenUngDung;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTenUngDung() {
        return tenUngDung;
    }

    public void setTenUngDung(String tenUngDung) {
        this.tenUngDung = tenUngDung;
    }
}
