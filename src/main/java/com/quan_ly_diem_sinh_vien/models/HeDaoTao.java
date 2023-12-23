/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
public class HeDaoTao {
    private int Id;
    private String HeDaoTao;
    private double ThoiHanDaoTao;

    public HeDaoTao() {
    }

    public HeDaoTao(int Id, String HeDaoTao, double ThoiHanDaoTao) {
        this.Id = Id;
        this.HeDaoTao = HeDaoTao;
        this.ThoiHanDaoTao = ThoiHanDaoTao;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHeDaoTao() {
        return HeDaoTao;
    }

    public void setHeDaoTao(String HeDaoTao) {
        this.HeDaoTao = HeDaoTao;
    }

    public double getThoiHanDaoTao() {
        return ThoiHanDaoTao;
    }

    public void setThoiHanDaoTao(double ThoiHanDaoTao) {
        this.ThoiHanDaoTao = ThoiHanDaoTao;
    }
    
    
}