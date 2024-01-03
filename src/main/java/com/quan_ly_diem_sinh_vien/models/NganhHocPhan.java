package com.quan_ly_diem_sinh_vien.models;

public class NganhHocPhan {
	private int Id;
	private int NganhId;
	private int HocPhanId;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getNganhId() {
		return NganhId;
	}
	public void setNganhId(int nganhId) {
		NganhId = nganhId;
	}
	public int getHocPhanId() {
		return HocPhanId;
	}
	public void setHocPhanId(int hocPhanId) {
		HocPhanId = hocPhanId;
	}
	
	
	public NganhHocPhan(int id, int nganhId, int hocPhanId) {
		Id = id;
		NganhId = nganhId;
		HocPhanId = hocPhanId;
	}
	
	public NganhHocPhan() {
		
	}
	
	public NganhHocPhan(int nganhId, int hocPhanId) {
		NganhId = nganhId;
		HocPhanId = hocPhanId;
	}
	
	
}
