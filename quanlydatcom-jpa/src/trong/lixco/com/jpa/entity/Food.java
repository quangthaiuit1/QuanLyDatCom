package trong.lixco.com.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food extends AbstractEntity{
	private String name;
	private String code;
	//ca lam viec
	private int shifts;
	private String image;

	private Date food_date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getShifts() {
		return shifts;
	}
	public void setShifts(int shifts) {
		this.shifts = shifts;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getFood_date() {
		return food_date;
	}
	public void setFood_date(Date food_date) {
		this.food_date = food_date;
	}
	
}
