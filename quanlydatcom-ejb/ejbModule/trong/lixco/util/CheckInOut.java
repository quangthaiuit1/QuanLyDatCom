package trong.lixco.util;

import java.util.Date;

public class CheckInOut {
	private long id;
	private String machamcong;
	private Date ngaycham;
	private Date giocham;
	private String tenmay;
	private String manhanvien;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMachamcong() {
		return machamcong;
	}
	public void setMachamcong(String machamcong) {
		this.machamcong = machamcong;
	}
	public Date getNgaycham() {
		return ngaycham;
	}
	public void setNgaycham(Date ngaycham) {
		this.ngaycham = ngaycham;
	}
	public Date getGiocham() {
		return giocham;
	}
	public void setGiocham(Date giocham) {
		this.giocham = giocham;
	}
	public String getTenmay() {
		return tenmay;
	}
	public void setTenmay(String tenmay) {
		this.tenmay = tenmay;
	}
	public String getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(String manhanvien) {
		this.manhanvien = manhanvien;
	}
	
}
