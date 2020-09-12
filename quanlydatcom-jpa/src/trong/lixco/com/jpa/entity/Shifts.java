package trong.lixco.com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Shifts extends AbstractEntity{
	private String name;
	private int time;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
