
package com.quan_ly_diem_sinh_vien.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LopHocPhanSinhVienDAO extends DAO{
	public static ArrayList<LopHocPhanSinhVien> list() {
        ArrayList<LopHocPhanSinhVien> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_lophocphan_sinhvien";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                int lopHocPhanId = rs.getInt("lophocphan_id");
                int sinhVienId = rs.getInt("sinhvien_id");
                // Khởi tạo đối tượng, thêm vào list
                LopHocPhanSinhVien item = new LopHocPhanSinhVien(id, lopHocPhanId, sinhVienId);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }
	
	public static LopHocPhanSinhVien find(int _id) {
		LopHocPhanSinhVien item = new LopHocPhanSinhVien();
        Connection con = connect();
        try {
            String sql = "select * from tbl_lophocphan_sinhvien where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int lopHocPhanId = rs.getInt("lophocphan_id");
                int sinhVienId = rs.getInt("sinhvien_id");

                item.setId(id);
                item.setLopHocPhanId(lopHocPhanId);
                item.setSinhVienId(sinhVienId);;
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }
	
	public static int create(LopHocPhanSinhVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_lophocphan_sinhvien`(`lophocphan_id`, `sinhvien_id`) values(?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , item.getLopHocPhanId());
            ps.setInt(2 , item.getSinhVienId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }
	
	public static int update(LopHocPhanSinhVien item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_lophocphan_sinhvien` SET `lophocphan_id`= ?,`sinhvien_id`= ? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1 , item.getLopHocPhanId());
            ps.setInt(2 , item.getSinhVienId());
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
            String sql = "delete from `tbl_lophocphan_sinhvien` where id = ?";
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
