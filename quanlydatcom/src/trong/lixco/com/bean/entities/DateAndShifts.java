package trong.lixco.com.bean.entities;

import java.util.Date;

public class DateAndShifts {
	private Date date;
	private long shiftsId;
	private int soluongdkithem;

	public int getSoluongdkithem() {
		return soluongdkithem;
	}

	public void setSoluongdkithem(int soluongdkithem) {
		this.soluongdkithem = soluongdkithem;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getShiftsId() {
		return shiftsId;
	}

	public void setShiftsId(long shiftsId) {
		this.shiftsId = shiftsId;
	}
}
