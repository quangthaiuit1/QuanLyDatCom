package trong.lixco.com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_food_by_date")
public class OrderAndFoodByDate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private OrderFood order_food;
	
	@ManyToOne 
	private FoodByDay food_by_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderFood getOrder_food() {
		return order_food;
	}

	public void setOrder_food(OrderFood order_food) {
		this.order_food = order_food;
	}

	public FoodByDay getFood_by_date() {
		return food_by_date;
	}

	public void setFood_by_date(FoodByDay food_by_date) {
		this.food_by_date = food_by_date;
	}
}
