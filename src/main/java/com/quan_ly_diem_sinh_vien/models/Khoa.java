/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
import java.sql.Date;

/**
 *
 * @author PC
 */
public class Khoa{
    
    private int Id;
    private String TenKhoa;
    private Date NgayThanhLap;

    public Khoa() {
    }

    public Khoa(int Id, String TenKhoa, Date NgayThanhLap) {
        this.Id = Id;
        this.TenKhoa = TenKhoa;
        this.NgayThanhLap = NgayThanhLap;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String TenKhoa) {
        this.TenKhoa = TenKhoa;
    }

    public Date getNgayThanhLap() {
        return NgayThanhLap;
    }

    public void setNgayThanhLap(Date NgayThanhLap) {
        this.NgayThanhLap = NgayThanhLap;
    }
    
    
    
}
