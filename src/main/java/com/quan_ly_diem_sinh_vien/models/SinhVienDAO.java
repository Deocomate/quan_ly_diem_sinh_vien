/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SinhVienDAO extends DAO {

    public static ArrayList<SinhVien> list() {
        ArrayList<SinhVien> list = new ArrayList<SinhVien>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_sinhvien";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                Date BirthOfDate = rs.getDate("birth_of_date");
                String Sex = rs.getString("sex");
                String Phone = rs.getString("phone");
                String Address = rs.getString("address");
                String Email = rs.getString("email");
                float Gpa = rs.getFloat("gpa");
                int LopbiencheId = rs.getInt("lopbienche_id");
                int NganhId = rs.getInt("nganh_id");
                // Khởi tạo đối tượng, thêm vào list
                SinhVien item = new SinhVien(Id, Name, BirthOfDate, Sex, Phone, Address, Email, Gpa, LopbiencheId, NganhId);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static SinhVien find(int _Id) {
        SinhVien item = new SinhVien();
        Connection con = connect();
        try {
            String sql = "select * from tbl_sinhvien where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _Id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                Date BirthOfDate = rs.getDate("birth_of_date");
                String Sex = rs.getString("sex");
                String Phone = rs.getString("phone");
                String Address = rs.getString("address");
                String Email = rs.getString("email");
                float Gpa = rs.getFloat("gpa");
                int LopbiencheId = rs.getInt("lopbienche_id");
                int NganhId = rs.getInt("nganh_id");

                item.setId(Id);
                item.setName(Name);
                item.setBirthOfDate(BirthOfDate);
                item.setSex(Sex);
                item.setPhone(Phone);
                item.setAddress(Address);
                item.setEmail(Email);
                item.setGpa(Gpa);
                item.setLopbiencheId(LopbiencheId);
                item.setNganhId(NganhId);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(SinhVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_sinhvien`(`Name`, `birth_of_date`, `sex`, `phone`, `address`, `email`, `gpa`, `lopbienche_id`, `nganh_id`) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setDate(2, item.getBirthOfDate());
            ps.setString(3, item.getSex());
            ps.setString(4, item.getPhone());
            ps.setString(5, item.getAddress());
            ps.setString(6, item.getEmail());
            ps.setFloat(7, item.getGpa());
            ps.setInt(8, item.getLopbiencheId());
            ps.setInt(9, item.getNganhId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(SinhVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_sinhvien` SET `name`=?,`birth_of_date`=?,`sex`=?,`phone`=?,`address`=?,`email`=?,`gpa`=?,`lopbienche_id`=?,`nganh_id`=? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setDate(2, item.getBirthOfDate());
            ps.setString(3, item.getSex());
            ps.setString(4, item.getPhone());
            ps.setString(5, item.getAddress());
            ps.setString(6, item.getEmail());
            ps.setFloat(7, item.getGpa());
            ps.setInt(8, item.getLopbiencheId());
            ps.setInt(9, item.getNganhId());
            ps.setInt(10, item.getId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int delete(int Id) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "delete from tbl_sinhvien where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }
}
