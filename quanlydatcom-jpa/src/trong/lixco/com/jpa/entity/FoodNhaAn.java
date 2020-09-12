package trong.lixco.com.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food_nha_an")
public class FoodNhaAn extends AbstractEntity{
	private String employee_code;
	private String employee_name;
	private String employee_id;
	private String department_code;
	private String department_name;
	private Date food_date;

	@OneToOne
	private Shifts shifts;
	@OneToOne
	private CategoryFood category_food;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
	public Shifts getShifts() {
		return shifts;
	}
	public void setShifts(Shifts shifts) {
		this.shifts = shifts;
	}
	public CategoryFood getCategory_food() {
		return category_food;
	}
	public void setCategory_food(CategoryFood category_food) {
		this.category_food = category_food;
	}
	public Date getFood_date() {
		return food_date;
	}
	public void setFood_date(Date food_date) {
		this.food_date = food_date;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
}
