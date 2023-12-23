/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
public class Nganh {

    private int Id;
    private String TenNganh;
    private int HeDaoTaoId;
    private int KhoaId;

    public Nganh() {
    }

    public Nganh(int Id, String TenNganh, int HeDaoTaoId, int KhoaId) {
        this.Id = Id;
        this.TenNganh = TenNganh;
        this.HeDaoTaoId = HeDaoTaoId;
        this.KhoaId = KhoaId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenNganh() {
        return TenNganh;
    }

    public void setTenNganh(String TenNganh) {
        this.TenNganh = TenNganh;
    }

    public int getHeDaoTaoId() {
        return HeDaoTaoId;
    }

    public void setHeDaoTaoId(int HeDaoTaoId) {
        this.HeDaoTaoId = HeDaoTaoId;
    }

    public int getKhoaId() {
        return KhoaId;
    }

    public void setKhoaId(int KhoaId) {
        this.KhoaId = KhoaId;
    }

}
