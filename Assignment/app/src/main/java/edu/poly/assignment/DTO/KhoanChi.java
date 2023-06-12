package edu.poly.assignment.DTO;

public class KhoanChi {
    private int stt;
    private String khoanChi;

    public KhoanChi() {
    }

    public KhoanChi(int stt, String khoanChi) {
        this.stt = stt;
        this.khoanChi = khoanChi;
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
}
