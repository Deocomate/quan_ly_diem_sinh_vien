/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author PC
 */
import java.sql.Date;
/**
 *
 * @author PC
 */
public class GiangVien {

    @Override
    public String toString() {
        return getName(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    int Id;
    String Name;
    Date BirthOfDate;
    String Sex;
    String Phone;
    String Address;
    String Email;

    public GiangVien() {
    }

    public GiangVien(int Id, String Name, Date BirthOfDate, String Sex, String Phone, String Address, String Email) {
        this.Id = Id;
        this.Name = Name;
        this.BirthOfDate = BirthOfDate;
        this.Sex = Sex;
        this.Phone = Phone;
        this.Address = Address;
        this.Email = Email;
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

}
