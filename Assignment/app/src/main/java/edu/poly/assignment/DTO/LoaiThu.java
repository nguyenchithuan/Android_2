package edu.poly.assignment.DTO;

public class LoaiThu {
    private int stt;
    private String khoanThu;
    private String loaiThu;
    private String thoiGian;

    public LoaiThu() {
    }

    public LoaiThu(int stt, String khoanThu, String loaiThu) {
        this.stt = stt;
        this.khoanThu = khoanThu;
        this.loaiThu = loaiThu;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(String khoanThu) {
        this.khoanThu = khoanThu;
    }

    public String getLoaiThu() {
        return loaiThu;
    }

    public void setLoaiThu(String loaiThu) {
        this.loaiThu = loaiThu;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
