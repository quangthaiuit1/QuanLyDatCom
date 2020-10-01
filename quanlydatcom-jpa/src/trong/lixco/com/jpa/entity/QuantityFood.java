package trong.lixco.com.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quantity_food_by_date")
public class QuantityFood extends AbstractEntity {
	private int tongsuatan;
	private int suatanchay;
	private int suatanman;
	private int suatandadangky;
	private Date food_date;
	private int tongsuatandkthem;
	private int tongsuatankhach;

	@OneToOne
	private Shifts shifts;

	public int getTongsuatankhach() {
		return tongsuatankhach;
	}

	public void setTongsuatankhach(int tongsuatankhach) {
		this.tongsuatankhach = tongsuatankhach;
	}

	public int getTongsuatandkthem() {
		return tongsuatandkthem;
	}

	public void setTongsuatandkthem(int tongsuatandkthem) {
		this.tongsuatandkthem = tongsuatandkthem;
	}

	public Date getFood_date() {
		return food_date;
	}

	public void setFood_date(Date food_date) {
		this.food_date = food_date;
	}

	public Shifts getShifts() {
		return shifts;
	}

	public void setShifts(Shifts shifts) {
		this.shifts = shifts;
	}

	public int getTongsuatan() {
		return tongsuatan;
	}

	public void setTongsuatan(int tongsuatan) {
		this.tongsuatan = tongsuatan;
	}

	public int getSuatanchay() {
		return suatanchay;
	}

	public void setSuatanchay(int suatanchay) {
		this.suatanchay = suatanchay;
	}

	public int getSuatanman() {
		return suatanman;
	}

	public void setSuatanman(int suatanman) {
		this.suatanman = suatanman;
	}

	public int getSuatandadangky() {
		return suatandadangky;
	}

	public void setSuatandadangky(int suatandadangky) {
		this.suatandadangky = suatandadangky;
	}
}
