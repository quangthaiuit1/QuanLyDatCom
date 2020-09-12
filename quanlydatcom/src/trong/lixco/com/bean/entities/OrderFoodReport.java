package trong.lixco.com.bean.entities;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class OrderFoodReport implements Comparable<OrderFoodReport> {
	private Date registrationDate;
	private long shift;
	private String foodName;
	private int soluong;

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public long getShift() {
		return shift;
	}

	public void setShift(long shift) {
		this.shift = shift;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public int compareTo(OrderFoodReport o) {
		return getRegistrationDate().compareTo(o.getRegistrationDate());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
		result = prime * result + (int) (shift ^ (shift >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderFoodReport other = (OrderFoodReport) obj;
		if (foodName == null) {
			if (other.foodName != null)
				return false;
		} else if (!foodName.equals(other.foodName))
			return false;
		if (shift != other.shift)
			return false;
		return true;
	}
	
//	
//	public class HolderData{
//		private Date registrationDate;
//		private List<Level1> listLevel1;
//	}
//	public class Level1{
//		private long shift;
//		private List<Level2> listLevel2;
//	}
//	public class Level2{
//		private String foodName;
//		private int quantity;
//	}
}
