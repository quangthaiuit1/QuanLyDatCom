package trong.lixco.com.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_food")
public class OrderFood extends AbstractEntity{
	@Column(name = "employee_code")
	private String employeeCode;
	@Column(name = "employee_name")
	private String employeeName;
	
	@OneToOne
	private Food food_shifts1;
	
	@OneToOne
	private Food food_shifts2;
	
	@OneToOne
	private Food food_shifts3;
	
	private Date registration_date;
	
	
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Food getFood_shifts1() {
		return food_shifts1;
	}
	public void setFood_shifts1(Food food_shifts1) {
		this.food_shifts1 = food_shifts1;
	}
	public Food getFood_shifts2() {
		return food_shifts2;
	}
	public void setFood_shifts2(Food food_shifts2) {
		this.food_shifts2 = food_shifts2;
	}
	public Food getFood_shifts3() {
		return food_shifts3;
	}
	public void setFood_shifts3(Food food_shifts3) {
		this.food_shifts3 = food_shifts3;
	}
	
}
