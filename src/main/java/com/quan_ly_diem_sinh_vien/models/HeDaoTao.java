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

    @Override
    public String toString() {
        return getTenHeDaoTao(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    private int Id;
    private String TenHeDaoTao;
    private double ThoiHanDaoTao;

    public HeDaoTao(int Id, String TenHeDaoTao, double ThoiHanDaoTao) {
        this.Id = Id;
        this.TenHeDaoTao = TenHeDaoTao;
        this.ThoiHanDaoTao = ThoiHanDaoTao;
    }

    public HeDaoTao() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenHeDaoTao() {
        return TenHeDaoTao;
    }

    public void setTenHeDaoTao(String TenHeDaoTao) {
        this.TenHeDaoTao = TenHeDaoTao;
    }

    public double getThoiHanDaoTao() {
        return ThoiHanDaoTao;
    }

    public void setThoiHanDaoTao(double ThoiHanDaoTao) {
        this.ThoiHanDaoTao = ThoiHanDaoTao;
    }

}
