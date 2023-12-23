/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
public class LopBienChe {

    int Id;
    String TenLop;
    int NganhId;
    int GiangvienId;

    public LopBienChe() {
    }

    ;
    
    public LopBienChe(int Id, String TenLop, int NganhId, int GiangvienId) {
        this.Id = Id;
        this.TenLop = TenLop;
        this.NganhId = NganhId;
        this.GiangvienId = GiangvienId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public int getNganhId() {
        return NganhId;
    }

    public void setNganhId(int NganhId) {
        this.NganhId = NganhId;
    }

    public int getGiangvienId() {
        return GiangvienId;
    }

    public void setGiangvienId(int GiangvienId) {
        this.GiangvienId = GiangvienId;
    }

}
