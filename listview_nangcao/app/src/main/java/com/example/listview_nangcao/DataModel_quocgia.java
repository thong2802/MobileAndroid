package com.example.listview_nangcao;

public class DataModel_quocgia {
    private String tenNuoc, thuDo;
    private int hinhAnh;

    public DataModel_quocgia(String tenNuoc, String thuDo, int hinhAnh) {
        this.tenNuoc = tenNuoc;
        this.thuDo = thuDo;
        this.hinhAnh = hinhAnh;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    public String getThuDo() {
        return thuDo;
    }

    public void setThuDo(String thuDo) {
        this.thuDo = thuDo;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
