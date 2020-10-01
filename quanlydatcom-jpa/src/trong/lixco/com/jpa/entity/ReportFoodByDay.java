package trong.lixco.com.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//bao suat an theo ngay
@Table(name = "report_food_by_day")
public class ReportFoodByDay extends AbstractEntity {
	private Date report_date;
	private int quantity;

	@OneToOne
	private Shifts shifts;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Shifts getShifts() {
		return shifts;
	}

	public void setShifts(Shifts shifts) {
		this.shifts = shifts;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
}
