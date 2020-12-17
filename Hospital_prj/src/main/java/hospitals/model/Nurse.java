package hospitals.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nurses")
public class Nurse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "idcard")
	private String idcard;
	
	@Column(name = "seniority")//thâm niên
	private String seniority;
	
	@Column(name = "literacy")//trình độ
	private String literacy;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	public Nurse() {}
//	public Nurse(String name, String idcard, long seniority, String literacy, String birthday, String address, String phone) {
//		this.name = name;
//		this.idcard = idcard;
//		this.seniority = seniority;
//		this.literacy = literacy;
//		this.birthday = birthday;
//		this.address = address;
//		this.phone = phone;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSeniority() {
		return seniority;
	}
	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}
	public String getLiteracy() {
		return literacy;
	}
	public void setLiteracy(String literacy) {
		this.literacy = literacy;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
