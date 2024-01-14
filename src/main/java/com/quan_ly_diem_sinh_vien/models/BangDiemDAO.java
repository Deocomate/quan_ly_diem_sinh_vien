/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.models;

import static com.quan_ly_diem_sinh_vien.models.DAO.connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lanta
 */
public class BangDiemDAO {

    public static ArrayList<BangDiem> findListVoiNganhHocPhanVaSinhVien(int NganhHocPhanId, int SinhVienId) {
        ArrayList<BangDiem> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "SELECT * FROM `tbl_bangdiem` WHERE `nganh_hocphan_id` = ? AND `sinhvien_id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, NganhHocPhanId);
            ps.setInt(2, SinhVienId);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                float diemchuyencan = rs.getFloat("diem_chuyen_can");
                float diemthi = rs.getFloat("diem_thi");
                Date ngaythi = rs.getDate("ngay_thi");
                int nganhhocphan_id = rs.getInt("nganh_hocphan_id");
                int sinhvien_id = rs.getInt("sinhvien_id");
                // Khởi tạo đối tượng, thêm vào list
                BangDiem item = new BangDiem(id, diemchuyencan, diemthi, ngaythi, nganhhocphan_id, sinhvien_id);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static ArrayList<BangDiem> listBangDiemThuocSinhVien(int SinhVienId) {
        ArrayList<BangDiem> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "SELECT * FROM `tbl_bangdiem` WHERE `sinhvien_id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, SinhVienId);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                float diemchuyencan = rs.getFloat("diem_chuyen_can");
                float diemthi = rs.getFloat("diem_thi");
                Date ngaythi = rs.getDate("ngay_thi");
                int nganhhocphan_id = rs.getInt("nganh_hocphan_id");
                int sinhvien_id = rs.getInt("sinhvien_id");
                // Khởi tạo đối tượng, thêm vào list
                BangDiem item = new BangDiem(id, diemchuyencan, diemthi, ngaythi, nganhhocphan_id, sinhvien_id);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static int createIfNotExist(BangDiem item) {
        int rows = 0;
        Connection con = connect();
        try {
            var listBangDiem = findListVoiNganhHocPhanVaSinhVien(item.getNganhHocphanId(), item.getSinhvienId());
            if (!listBangDiem.isEmpty()) {
                return 0;
            }
            String sql = "INSERT INTO `tbl_bangdiem`(`diem_chuyen_can`, `diem_thi`, `ngay_thi`, `nganh_hocphan_id`, `sinhvien_id`) VALUES (?,?,null,?,?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, item.getDiemChuyenCan());
            ps.setFloat(2, item.getDiemThi());
            ps.setInt(3, item.getNganhHocphanId());
            ps.setInt(4, item.getSinhvienId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(BangDiem item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_bangdiem` SET `diem_chuyen_can`=?,`diem_thi`=?,`ngay_thi`=?,`nganh_hocphan_id`=?,`sinhvien_id`=? WHERE id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setFloat(1, item.getDiemChuyenCan());
            ps.setFloat(2, item.getDiemThi());
            ps.setDate(3, item.getNgayThi());
            ps.setInt(4, item.getNganhHocphanId());
            ps.setInt(5, item.getSinhvienId());
            ps.setInt(6, item.getId());

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
