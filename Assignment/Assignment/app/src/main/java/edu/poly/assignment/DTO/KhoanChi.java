package edu.poly.assignment.DTO;

public class KhoanChi {
    private int stt;
    private String khoanChi;
    private String loaiChi;
    private String thoiGian;

    public KhoanChi() {
    }

    public KhoanChi(int stt, String khoanChi, String loaiChi) {
        this.stt = stt;
        this.khoanChi = khoanChi;
        this.loaiChi = loaiChi;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getKhoanChi() {
        return khoanChi;
    }

    public void setKhoanChi(String khoanChi) {
        this.khoanChi = khoanChi;
    }

    public String getLoaiChi() {
        return loaiChi;
    }

    public void setLoaiChi(String loaiChi) {
        this.loaiChi = loaiChi;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
