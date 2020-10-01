package trong.lixco.com.bean.entities;

import java.util.Date;

public class ChiTietDuBaoSuatAn {
	private long id;
	private Date ngay;
	private String calamviec;
	private String tenmon;
	private int soluong;
	
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getNgay() {
		return ngay;
	}
	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}
	public String getCalamviec() {
		return calamviec;
	}
	public void setCalamviec(String calamviec) {
		this.calamviec = calamviec;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
}
