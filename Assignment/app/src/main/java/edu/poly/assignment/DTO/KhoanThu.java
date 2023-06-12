package edu.poly.assignment.DTO;

public class KhoanThu {
    private int stt;
    private String khoanThu;

    public KhoanThu() {
    }

    public KhoanThu(int stt, String khoanThu) {
        this.stt = stt;
        this.khoanThu = khoanThu;
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
}
