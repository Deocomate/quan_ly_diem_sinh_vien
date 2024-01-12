package com.quan_ly_diem_sinh_vien.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NganhHocPhanDAO extends DAO {

    public static ArrayList<NganhHocPhan> list() {
        ArrayList<NganhHocPhan> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_nganh_hocphan";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                int nganhId = rs.getInt("nganh_id");
                int hocPhanId = rs.getInt("hocphan_id");
                // Khởi tạo đối tượng, thêm vào list
                NganhHocPhan item = new NganhHocPhan(id, nganhId, hocPhanId);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }

    public static NganhHocPhan find(int _id) {
        NganhHocPhan item = new NganhHocPhan();
        Connection con = connect();
        try {
            String sql = "select * from tbl_nganh_hocphan where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int nganhId = rs.getInt("nganh_id");
                int hocPhanId = rs.getInt("hocphan_id");

                item.setId(id);
                item.setNganhId(nganhId);
                item.setHocPhanId(hocPhanId);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }

    public static int create(NganhHocPhan item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_nganh_hocphan`(`nganh_id`, `hocphan_id`) values(?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item.getNganhId());
            ps.setInt(2, item.getHocPhanId());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }

    public static int update(NganhHocPhan item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_nganh_hocphan` SET `nganh_id`= ?,`hocphan_id`= ? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item.getNganhId());
            ps.setInt(2, item.getHocPhanId());
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
            String sql = "delete from tbl_nganh_hocphan where id = ?";
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

    public static ArrayList<HocPhan> findListHocPhanThuocNganh(int NganhId) {
        ArrayList<HocPhan> listHocPhan = new ArrayList<>();
        ArrayList<NganhHocPhan> nganhHocPhanList = list();
        for (NganhHocPhan i : nganhHocPhanList) {
            if (i.getNganhId() == NganhId) {
                listHocPhan.add(HocPhanDAO.find(i.getHocPhanId()));
            }
        }
        return listHocPhan;
    }

    public static int deleteNganhTrongHocPhan(int NganhId, int HocphanId) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "DELETE FROM `tbl_nganh_hocphan` WHERE `nganh_id` = ? AND `hocphan_id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, NganhId);
            ps.setInt(2, HocphanId);
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
