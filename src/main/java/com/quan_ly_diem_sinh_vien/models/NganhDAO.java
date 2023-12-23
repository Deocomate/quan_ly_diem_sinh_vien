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
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class NganhDAO extends DAO {

    public static ArrayList<Nganh> list() {
        ArrayList<Nganh> list = new ArrayList<Nganh>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_nganh";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                String ten_nganh = rs.getString("ten_nganh");
                int he_dao_tao_id = rs.getInt("he_dao_tao_id");
                int khoa_id = rs.getInt("khoa_id");
                // Khởi tạo đối tượng, thêm vào list
                Nganh item = new Nganh(id, ten_nganh, he_dao_tao_id, khoa_id);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static Nganh find(int _id) {
        Nganh item = new Nganh();
        Connection con = connect();
        try {
            String sql = "select * from tbl_nganh where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten_nganh = rs.getString("ten_nganh");
                int he_dao_tao_id = rs.getInt("he_dao_tao_id");
                int khoa_id = rs.getInt("khoa_id");

                item.setId(id);
                item.setTenNganh(ten_nganh);
                item.setHeDaoTaoId(he_dao_tao_id);
                item.setKhoaId(khoa_id);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(Nganh item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_nganh`(`ten_nganh`, `hedaotao_id`, `khoa_id`) values(?, ?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenNganh());
            ps.setInt(2, item.getHeDaoTaoId());
            ps.setInt(3, item.getKhoaId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(Nganh item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_nganh` SET `ten_nganh`=?,`hedaotao_id`=?,`khoa_id`=? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenNganh());
            ps.setInt(2, item.getHeDaoTaoId());
            ps.setInt(3, item.getKhoaId());
            ps.setInt(4, item.getId());
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
            String sql = "delete from tbl_nganh where id = ?";
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
