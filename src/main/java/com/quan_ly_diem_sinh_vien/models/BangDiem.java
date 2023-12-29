/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BangDiem {

    private int Id;
    private float DiemChuyenCan;
    private float DiemThi;
    private Date NgayThi;
    private int NganhHocphanId;
    private int SinhvienId;

    public BangDiem() {

    }

    public BangDiem(int Id, float DiemChuyenCan, float DiemThi, Date NgayThi, int NganhHocphanId, int SinhvienId) {
        this.Id = Id;
        this.DiemChuyenCan = DiemChuyenCan;
        this.DiemThi = DiemThi;
        this.NgayThi = NgayThi;
        this.NganhHocphanId = NganhHocphanId;
        this.SinhvienId = SinhvienId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public float getDiemChuyenCan() {
        return DiemChuyenCan;
    }

    public void setDiemChuyenCan(float DiemChuyenCan) {
        this.DiemChuyenCan = DiemChuyenCan;
    }

    public float getDiemThi() {
        return DiemThi;
    }

    public void setDiemThi(float DiemThi) {
        this.DiemThi = DiemThi;
    }

    public Date getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(Date NgayThi) {
        this.NgayThi = NgayThi;
    }

    public int getNganhHocphanId() {
        return NganhHocphanId;
    }

    public void setNganhHocphanId(int NganhHocphanId) {
        this.NganhHocphanId = NganhHocphanId;
    }

    public int getSinhvienId() {
        return SinhvienId;
    }

    public void setSinhvienId(int SinhvienId) {
        this.SinhvienId = SinhvienId;
    }
}
