package trong.lixco.com.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food_by_day")
public class FoodByDay extends AbstractEntity{
	
	private Date food_date;
	
	@OneToOne
	private Shifts shifts;
	
	@OneToOne
	private CategoryFood category_food;

	public Shifts getShifts() {
		return shifts;
	}

	public void setShifts(Shifts shifts) {
		this.shifts = shifts;
	}

	public Date getFood_date() {
		return food_date;
	}

	public void setFood_date(Date food_date) {
		this.food_date = food_date;
	}

	public CategoryFood getCategory_food() {
		return category_food;
	}

	public void setCategory_food(CategoryFood category_food) {
		this.category_food = category_food;
	}
}
