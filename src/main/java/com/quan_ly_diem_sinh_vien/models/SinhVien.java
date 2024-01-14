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
public class SinhVien {

    @Override
    public String toString() {
        int id = getId();
        String ten = getName();
        String _class = LopBienCheDAO.find(getLopbiencheId()).getTenLop();
        return id + " - " + ten + " - " + _class;
    }

    int Id;
    String Name;
    Date BirthOfDate;
    String Sex;
    String Phone;
    String Address;
    String Email;
    String Status;
    float Gpa;
    int LopbiencheId;
    int NganhId;

    public SinhVien() {

    }

    ;
    public SinhVien(int Id, String Name, Date BirthOfDate, String Sex, String Phone, String Address, String Email, float Gpa, int LopbiencheId, int NganhId, String Status) {
        this.Id = Id;
        this.Name = Name;
        this.BirthOfDate = BirthOfDate;
        this.Sex = Sex;
        this.Phone = Phone;
        this.Address = Address;
        this.Email = Email;
        this.Gpa = Gpa;
        this.LopbiencheId = LopbiencheId;
        this.NganhId = NganhId;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getBirthOfDate() {
        return BirthOfDate;
    }

    public void setBirthOfDate(Date BirthOfDate) {
        this.BirthOfDate = BirthOfDate;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public float getGpa() {
        return Gpa;
    }

    public void setGpa(float Gpa) {
        this.Gpa = Gpa;
    }

    public int getLopbiencheId() {
        return LopbiencheId;
    }

    public void setLopbiencheId(int LopbiencheId) {
        this.LopbiencheId = LopbiencheId;
    }

    public int getNganhId() {
        return NganhId;
    }

    public void setNganhId(int NganhId) {
        this.NganhId = NganhId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
