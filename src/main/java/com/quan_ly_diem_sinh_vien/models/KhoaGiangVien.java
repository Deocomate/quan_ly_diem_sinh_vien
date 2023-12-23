/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
public class KhoaGiangVien {

    int Id;
    int KhoaId;
    int GiangvienId;

    public KhoaGiangVien() {
    }

    public KhoaGiangVien(int Id, int KhoaId, int GiangvienId) {
        this.Id = Id;
        this.KhoaId = KhoaId;
        this.GiangvienId = GiangvienId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getKhoaId() {
        return KhoaId;
    }

    public void setKhoaId(int KhoaId) {
        this.KhoaId = KhoaId;
    }

    public int getGiangvienId() {
        return GiangvienId;
    }

    public void setGiangvienId(int GiangvienId) {
        this.GiangvienId = GiangvienId;
    }

}
