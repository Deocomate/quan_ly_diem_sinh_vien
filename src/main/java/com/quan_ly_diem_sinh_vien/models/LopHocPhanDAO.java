package com.quan_ly_diem_sinh_vien.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class LopHocPhanDAO extends DAO {

    public static ArrayList<LopHocPhan> list() {
        ArrayList<LopHocPhan> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_lophocphan";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                String tenHocPhan = rs.getString("ten_lophocphan");
                int nganhHocPhanId = rs.getInt("nganh_hocphan_id");
                int giangVienId = rs.getInt("giangvien_id");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                Date ngayThi = rs.getDate("ngay_thi");
                // Khởi tạo đối tượng, thêm vào list
                LopHocPhan item = new LopHocPhan(id, tenHocPhan, nganhHocPhanId, giangVienId, ngayBatDau, ngayKetThuc, ngayThi);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static LopHocPhan find(int _id) {
        LopHocPhan item = new LopHocPhan();
        Connection con = connect();
        try {
            String sql = "select * from tbl_lophocphan where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String tenHocPhan = rs.getString("ten_lophocphan");
                int nganhHocPhanId = rs.getInt("nganh_hocphan_id");
                int giangVienId = rs.getInt("giangvien_id");
                Date ngayBatDau = rs.getDate("ngay_bat_dau");
                Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                Date ngayThi = rs.getDate("ngay_thi");

                item.setId(id);
                item.setTenHocPhan(tenHocPhan);
                item.setNganhHocPhanId(nganhHocPhanId);
                item.setGiangVien_id(giangVienId);
                item.setNgayBatDau(ngayBatDau);
                item.setNgayKetThuc(ngayKetThuc);
                item.setNgayThi(ngayThi);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(LopHocPhan item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_lophocphan`(`ten_lophocphan`, `nganh_hocphan_id`, `giangvien_id`, `ngay_bat_dau`, `ngay_ket_thuc`, `ngay_thi`) values(?, ?, ?, ?, ?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenHocPhan());
            ps.setInt(2, item.getNganhHocPhanId());
            ps.setInt(3, item.getGiangVien_id());
            ps.setDate(4, item.getNgayBatDau());
            ps.setDate(5, item.getNgayKetThuc());
            ps.setDate(6, item.getNgayThi());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(LopHocPhan item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_lophocphan` SET `ten_lophocphan` = ?, `nganh_hocphan_id` = ?,"
                    + " `giangvien_id` = ?, `ngay_bat_dau` = ?, `ngay_ket_thuc` = ?, `ngay_thi` = ? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenHocPhan());
            ps.setInt(2, item.getNganhHocPhanId());
            ps.setInt(3, item.getGiangVien_id());
            ps.setDate(4, item.getNgayBatDau());
            ps.setDate(5, item.getNgayKetThuc());
            ps.setDate(6, item.getNgayThi());
            ps.setInt(7, item.getId());
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
            String sql = "delete from tbl_lophocphan where id = ?";
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
