package trong.lixco.com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food_customer")
public class FoodCustomer extends AbstractEntity{
	private String foodName;
	private int quantity;
	private	int price;
	
	@OneToOne
	private QuantityFood quantity_food;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public QuantityFood getQuantity_food() {
		return quantity_food;
	}
	public void setQuantity_food(QuantityFood quantity_food) {
		this.quantity_food = quantity_food;
	}
}
