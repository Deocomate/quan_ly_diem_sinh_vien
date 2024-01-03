
package com.quan_ly_diem_sinh_vien.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HocPhanDAO extends DAO {
	public static ArrayList<HocPhan> list() {
        ArrayList<HocPhan> list = new ArrayList<>();
        Connection con = connect();
        try {
            String sql = "select * from tbl_hocphan";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lấy dữ liệu về
                int id = rs.getInt("id");
                String tenHocPhan = rs.getString("ten_hocphan");
                int soTinChi = rs.getInt("so_tin_chi");
                // Khởi tạo đối tượng, thêm vào list
                HocPhan item = new HocPhan(id, tenHocPhan, soTinChi);
                list.add(item);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return list;
    }
	
	public static HocPhan find(int _id) {
        HocPhan item = new HocPhan();
        Connection con = connect();
        try {
            String sql = "select * from tbl_hocphan where id = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, _id);
            // Execute: thực thi câu lệnh vừa xong
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String tenHocPhan = rs.getString("ten_hocphan");
                int soTinChi = rs.getInt("so_tin_chi");

                item.setId(id);
                item.setTenHocPhan(tenHocPhan);
                item.setId(soTinChi);
            }
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return item;
    }
	
    public static int create(HocPhan item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "INSERT INTO `tbl_hocphan`(`ten_hocphan`, `so_tin_chi`) values(?, ?)";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1 , item.getTenHocPhan());
            ps.setInt(2 , item.getSoTinChi());
            // Execute: thực thi câu lệnh vừa xong
            rows = ps.executeUpdate();
            // Hủy kết nốt đến database để đỡ tốn tài nguyên
            con.close();
        } catch (Exception ex) {
            System.out.println("Error!!!" + ex.toString());
        }
        return rows;
    }
    
    public static int update(HocPhan item) {
        int rows = 0;
        Connection con = connect();
        try {
            String sql = "UPDATE `tbl_hocphan` SET `ten_hocphan`= ?,`so_tin_chi`= ? WHERE `id` = ?";
            // Prepare: chuẩn bị 1 câu lệnh
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getTenHocPhan());
            ps.setInt(2, item.getSoTinChi());
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
            String sql = "delete from tbl_hocphan where id = ?";
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
