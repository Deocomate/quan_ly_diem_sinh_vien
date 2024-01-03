package com.quan_ly_diem_sinh_vien.models;

public class LopHocPhanSinhVien {
	private int Id, LopHocPhanId, SinhVienId;

	public LopHocPhanSinhVien(int id, int lopHocPhanId, int sinhVienId) {
		super();
		Id = id;
		LopHocPhanId = lopHocPhanId;
		SinhVienId = sinhVienId;
	}

	public LopHocPhanSinhVien() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getLopHocPhanId() {
		return LopHocPhanId;
	}

	public void setLopHocPhanId(int lopHocPhanId) {
		LopHocPhanId = lopHocPhanId;
	}

	public int getSinhVienId() {
		return SinhVienId;
	}

	public void setSinhVienId(int sinhVienId) {
		SinhVienId = sinhVienId;
	}
	
	
}