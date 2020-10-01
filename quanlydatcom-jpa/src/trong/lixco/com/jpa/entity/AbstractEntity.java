package trong.lixco.com.jpa.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	protected Long id;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate = new Date();
	
	@Column(name = "modify_date")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;
	
	@Column(name = "created_user")
	protected String createdUser;
	@Column(name = "modified_user")
	protected String modifiedUser;
	@Column(columnDefinition = "TEXT")
	protected String note;
	private boolean disable=false;// tat nhan vien
	private boolean oldData=false;//du lieu cu
	
	@Transient
	private boolean select=false;
	@Transient
	private int index=0;
	@Transient
	private boolean color=false;
	
	public Long getId() {
		return id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	
	public boolean isOldData() {
		return oldData;
	}
	public void setOldData(boolean oldData) {
		this.oldData = oldData;
	}
	
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AbstractEntity other = (AbstractEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
