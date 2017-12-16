package HibernateMapping.MappingDemo;

import javax.persistence.*;

@Entity
@Table
public class AddressClass {
	@Id
	@Column(name="a_id")
	private int aid;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public AddressClass(int aid, String city, String state) {
		super();
		this.aid = aid;
		this.city = city;
		this.state = state;
	}
	public AddressClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AddressClass [aid=" + aid + ", city=" + city + ", state="
				+ state + "]";
	}
	
	

}
