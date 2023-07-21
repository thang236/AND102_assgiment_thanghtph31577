package com.example.and102_assgiment_thanghtph31577;

public class SanPhamModel {
    private  int masp;
    private  String tensp;
    private  double giaban;
    private int soluong;

    public SanPhamModel() {
    }

    public SanPhamModel(int masp, String tensp, double giaban, int soluong) {
        this.masp = masp;
        this.tensp = tensp;
        this.giaban = giaban;
        this.soluong = soluong;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
