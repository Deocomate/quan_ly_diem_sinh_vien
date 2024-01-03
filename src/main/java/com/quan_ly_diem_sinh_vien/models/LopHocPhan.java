package com.quan_ly_diem_sinh_vien.models;

import java.sql.Date;

public class LopHocPhan {
	private int Id;
	private String TenHocPhan;
	private int NganhHocPhanId;
	private int GiangVien_id;
	private Date NgayBatDau;
	private Date NgayKetThuc;
	private Date NgayThi;
	
	public LopHocPhan(int id, String tenHocPhan, int nganhHocPhanId, int giangVien_id, Date ngayBatDau,
			Date ngayKetThuc, Date ngayThi) {
		super();
		Id = id;
		TenHocPhan = tenHocPhan;
		NganhHocPhanId = nganhHocPhanId;
		GiangVien_id = giangVien_id;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		NgayThi = ngayThi;
	}
	
	public LopHocPhan() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTenHocPhan() {
		return TenHocPhan;
	}

	public void setTenHocPhan(String tenHocPhan) {
		TenHocPhan = tenHocPhan;
	}

	public int getNganhHocPhanId() {
		return NganhHocPhanId;
	}

	public void setNganhHocPhanId(int nganhHocPhanId) {
		NganhHocPhanId = nganhHocPhanId;
	}

	public int getGiangVien_id() {
		return GiangVien_id;
	}

	public void setGiangVien_id(int giangVien_id) {
		GiangVien_id = giangVien_id;
	}

	public Date getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public Date getNgayThi() {
		return NgayThi;
	}

	public void setNgayThi(Date ngayThi) {
		NgayThi = ngayThi;
	}
	
}