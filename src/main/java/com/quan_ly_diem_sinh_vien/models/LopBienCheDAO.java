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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LopBienCheDAO extends DAO {

    public static ArrayList<LopBienChe> list() {
        ArrayList<LopBienChe> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_lopbienche";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                String ten_lop = rs.getString("ten_lop");
                int nganh_id = rs.getInt("nganh_id");
                int giangvien_id = rs.getInt("giangvien_id");

                // Khởi tạo đối tượng, thêm vào list
                LopBienChe item = new LopBienChe(id, ten_lop, nganh_id, giangvien_id);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static LopBienChe find(int _id) {
        LopBienChe item = new LopBienChe();
        Connection con = connect();
        try {
            String sql = "select * from tbl_lopbienche where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten_lop = rs.getString("ten_lop");
                int nganh_id = rs.getInt("nganh_id");
                int giangvien_id = rs.getInt("giangvien_id");

                item.setId(id);
                item.setTenLop(ten_lop);
                item.setNganhId(nganh_id);
                item.setGiangvienId(giangvien_id);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(LopBienChe item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_lopbienche`(`ten_lop`, `nganh_id`, `giangvien_id`)  values(?, ?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenLop());
            ps.setInt(2, item.getNganhId());
            ps.setInt(3, item.getGiangvienId());

            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(LopBienChe item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_lopbienche` SET `ten_lop`=?,`nganh_id`=?,`giangvien_id`=? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenLop());
            ps.setInt(2, item.getNganhId());
            ps.setInt(3, item.getGiangvienId());
            ps.setInt(4, item.getId());

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
            String sql = "delete from tbl_lopbienche where id = ?";
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

