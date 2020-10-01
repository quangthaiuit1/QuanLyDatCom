package trong.lixco.com.bean.entities;

import java.util.Date;

public class BaoChenhLech {
	private Date ngay;
	private long ca;
	private String tenca;
	private String tenmonan;
	private int soluongchinhxac;
	private int soluongthucte;
	private long idmonan;
	private int soluongdkthem_dubao;

	public int getSoluongdkthem_dubao() {
		return soluongdkthem_dubao;
	}

	public void setSoluongdkthem_dubao(int soluongdkthem_dubao) {
		this.soluongdkthem_dubao = soluongdkthem_dubao;
	}

	public long getIdmonan() {
		return idmonan;
	}

	public void setIdmonan(long idmonan) {
		this.idmonan = idmonan;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public long getCa() {
		return ca;
	}

	public void setCa(long ca) {
		this.ca = ca;
	}

	public String getTenca() {
		return tenca;
	}

	public void setTenca(String tenca) {
		this.tenca = tenca;
	}

	public String getTenmonan() {
		return tenmonan;
	}

	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}

	public int getSoluongchinhxac() {
		return soluongchinhxac;
	}

	public void setSoluongchinhxac(int soluongchinhxac) {
		this.soluongchinhxac = soluongchinhxac;
	}

	public int getSoluongthucte() {
		return soluongthucte;
	}

	public void setSoluongthucte(int soluongthucte) {
		this.soluongthucte = soluongthucte;
	}
}
