/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class HeDaoTaoDAO extends DAO {

    public static ArrayList<HeDaoTao> list() {
        ArrayList<HeDaoTao> list = new ArrayList<HeDaoTao>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_hedaotao";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                String he_dao_tao = rs.getString("ten_hedaotao");
                double thoi_han_dao_tao = rs.getDouble("thoi_han_dao_tao");
                // Khởi tạo đối tượng, thêm vào list
                HeDaoTao item = new HeDaoTao(id, he_dao_tao, thoi_han_dao_tao);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static HeDaoTao find(int _id) {
        HeDaoTao item = new HeDaoTao();
        Connection con = connect();
        try {
            String sql = "select * from tbl_hedaotao where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String he_dao_tao = rs.getString("ten_hedaotao");
                double thoi_han_dao_tao = rs.getDouble("thoi_han_dao_tao");

                item.setId(id);
                item.setTenHeDaoTao(he_dao_tao);
                item.setThoiHanDaoTao(thoi_han_dao_tao);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(HeDaoTao item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_hedaotao`(`ten_hedaotao`, `thoi_han_dao_tao`) values(?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenHeDaoTao());
            ps.setDouble(2, item.getThoiHanDaoTao());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(HeDaoTao item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_hedaotao` SET `ten_hedaotao`= ? ,`thoi_han_dao_tao`= ? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenHeDaoTao());
            ps.setDouble(2, item.getThoiHanDaoTao());
            ps.setInt(3, item.getId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int delete(int id) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "delete from `tbl_hedaotao` where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
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
