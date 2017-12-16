 
package bidiret_mappingdemo;

import javax.persistence.*;

@Entity
@Table(name="Bi_Address")
public class AddressClass {
	@Id
	@Column(name="a_id")
	private int aid;
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	//@PrimaryKeyJoinColumn
	//@JoinColumn(name="EMP_ID")
	//@JoinTable(name="Join_Table")
	
	/*
	 * =>In Bi-directional mapping add @OneToOne annotation in both class
	 * 
	 * =>but no need to specify @PrimaryKeyJoinColumn, @JoinColumn, @JoinTable 
	 * annotation in both class
	 */
	EmployeePojoClass emp;

	public AddressClass(int aid, String city, String state,
			EmployeePojoClass emp) {
		super();
		this.aid = aid;
		this.city = city;
		this.state = state;
		this.emp = emp;
	}

	public AddressClass() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public EmployeePojoClass getEmp() {
		return emp;
	}

	public void setEmp(EmployeePojoClass emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "AddressClass [aid=" + aid + ", city=" + city + ", state="
				+ state + ", emp=" + emp + "]";
	}
	
	

}
