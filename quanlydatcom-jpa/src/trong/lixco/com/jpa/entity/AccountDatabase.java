package trong.lixco.com.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/*
 * 1. Host quan ly account (Account database)
 * 2. Host web
 */
@Entity
@Table(name="accountdatabase")
public class AccountDatabase extends AbstractEntity{
	private String address;
	private String name;
	private String addressPublic;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getAddressPublic() {
		return addressPublic;
	}

	public void setAddressPublic(String addressPublic) {
		this.addressPublic = addressPublic;
	}

	@Override
	public String toString() {
		return "AccountDatabase [address=" + address + ", name=" + name + ", id=" + id + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", createdUser=" + createdUser + ", note=" + note + "]";
	}

	
	
}
