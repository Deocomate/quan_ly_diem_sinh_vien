package com.quan_ly_diem_sinh_vien.models;

public class HocPhan {

    private int Id;
    private String TenHocPhan;
    private int SoTinChi;

    @Override
    public String toString() {
        return this.getTenHocPhan(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenHocPhan() {
        return TenHocPhan;
    }

    public HocPhan(String tenHocPhan, int soTinChi) {
        super();
        TenHocPhan = tenHocPhan;
        SoTinChi = soTinChi;
    }

    public void setTenHocPhan(String tenHocPhan) {
        TenHocPhan = tenHocPhan;
    }

    public int getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        SoTinChi = soTinChi;
    }

    public HocPhan(int id, String tenHocPhan, int soTinChi) {
        super();
        Id = id;
        TenHocPhan = tenHocPhan;
        SoTinChi = soTinChi;
    }

    public HocPhan() {

    }

}
