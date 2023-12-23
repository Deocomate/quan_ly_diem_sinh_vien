/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
import static Model.DAO.connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class GiangVienDAO extends DAO{

    public static ArrayList<GiangVien> list() {
        ArrayList<GiangVien> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_giangvien";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birth_of_date = rs.getDate("birth_of_date");
                String sex = rs.getString("sex");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");

                // Khởi tạo đối tượng, thêm vào list
                GiangVien item = new GiangVien(id, name, birth_of_date, sex, phone, address, email);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static GiangVien find(int _id) {
        GiangVien item = new GiangVien();
        Connection con = connect();
        try {
            String sql = "select * from tbl_giangvien where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birth_of_date = rs.getDate("birth_of_date");
                String sex = rs.getString("sex");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");

                item.setId(id);
                item.setName(name);
                item.setBirthOfDate(birth_of_date);
                item.setSex(sex);
                item.setPhone(phone);
                item.setAddress(address);
                item.setEmail(email);

            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(GiangVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_giangvien`(`name`, `birth_of_date`, `sex`, `phone`, `address`, `email`)  values(?, ?, ?, ?, ?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setDate(2, item.getBirthOfDate());
            ps.setString(3, item.getSex());
            ps.setString(4, item.getPhone());
            ps.setString(5, item.getAddress());
            ps.setString(6, item.getEmail());

            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(GiangVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_giangvien` SET `name`=?,`birth_of_date`=?,`sex`=?,`phone`=?,`address`=?,`email`=? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setDate(2, item.getBirthOfDate());
            ps.setString(3, item.getSex());
            ps.setString(4, item.getPhone());
            ps.setString(5, item.getAddress());
            ps.setString(6, item.getEmail());
            ps.setInt(7, item.getId());

            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int delete(int id) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "delete from tbl_giangvien where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }
}