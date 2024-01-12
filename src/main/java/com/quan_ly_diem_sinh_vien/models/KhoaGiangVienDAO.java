/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

/**
 *
 * @author datdn
 */
import static com.quan_ly_diem_sinh_vien.models.NganhHocPhanDAO.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class KhoaGiangVienDAO extends DAO {

    public static ArrayList<KhoaGiangVien> list() {
        ArrayList<KhoaGiangVien> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_khoa_giangvien";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                int khoa_id = rs.getInt("khoa_id");
                int giangvien_id = rs.getInt("giangvien_id");

                // Khởi tạo đối tượng, thêm vào list
                KhoaGiangVien item = new KhoaGiangVien(id, khoa_id, giangvien_id);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static KhoaGiangVien find(int _id) {
        KhoaGiangVien item = new KhoaGiangVien();
        Connection con = connect();
        try {
            String sql = "select * from tbl_khoa_giangvien where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int khoa_id = rs.getInt("khoa_id");
                int giangvien_id = rs.getInt("giangvien_id");

                item.setId(id);
                item.setKhoaId(khoa_id);
                item.setGiangvienId(giangvien_id);

            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(KhoaGiangVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_khoa_giangvien`(`khoa_id`, `giangvien_id`)  values(?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item.getKhoaId());
            ps.setInt(2, item.getGiangvienId());

            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(KhoaGiangVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_khoa_giangvien` SET `khoa_id`=?,`giangvien_id`=? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item.getKhoaId());
            ps.setInt(2, item.getGiangvienId());
            ps.setInt(3, item.getId());

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
            String sql = "delete from tbl_khoa_giangvien where id = ?";
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

    public static ArrayList<Khoa> findListKhoaThuocGiangVien(int GiangVienId) {
        ArrayList<Khoa> returnList = new ArrayList<>();
        ArrayList<KhoaGiangVien> mainList = list();
        for (KhoaGiangVien i : mainList) {
            if (i.getGiangvienId() == GiangVienId) {
                returnList.add(KhoaDAO.find(i.getKhoaId()));
            }
        }
        return returnList;
    }
}
