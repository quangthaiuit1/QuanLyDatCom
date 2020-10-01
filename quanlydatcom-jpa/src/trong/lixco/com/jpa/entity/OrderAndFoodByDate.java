package trong.lixco.com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_food_by_day")
public class OrderAndFoodByDate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private OrderFood order_food;

	@ManyToOne
	private FoodByDay food_by_day;

	private int quantity_plus;

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

	public FoodByDay getFood_by_day() {
		return food_by_day;
	}

	public void setFood_by_day(FoodByDay food_by_day) {
		this.food_by_day = food_by_day;
	}

	public int getQuantity_plus() {
		return quantity_plus;
	}

	public void setQuantity_plus(int quantity_plus) {
		this.quantity_plus = quantity_plus;
	}
}
