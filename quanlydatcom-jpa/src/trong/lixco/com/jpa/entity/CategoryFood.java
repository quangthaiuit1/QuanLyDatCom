package trong.lixco.com.jpa.entity;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category_food")
public class CategoryFood extends AbstractEntity {
	private String name;
	private byte[] image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String imageString() {
		try {
			return new String(Base64.getEncoder().encodeToString(image));
		} catch (Exception e) {
			return "";
		}
		
	}
}
