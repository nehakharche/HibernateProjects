package bidiret_mappingdemo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
/*
 * This the example of Bi-directional Mapping
 */
@Entity
@Table(name="Bi_Emp")
public class EmployeePojoClass {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="E_ID")
	int emp_id;
	@Column (name="Name")
	String emp_name;
	@Column (name="Designation")
	String emp_designation;
	
	@OneToOne (cascade=CascadeType.ALL)	
    //@PrimaryKeyJoinColumn
	//@JoinColumn
	@JoinTable(name="Combined_Table")
	/*@JoinTable(
	        name="Joined_Table",
	        joinColumns=
	            @JoinColumn(name="E_ID", referencedColumnName="E_ID"),
	        inverseJoinColumns=
	            @JoinColumn(name="a_id", referencedColumnName="a_id")
	    )*/
	
	AddressClass ad;
	
	public EmployeePojoClass(int emp_id, String emp_name,
			String emp_designation, AddressClass ad) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_designation = emp_designation;
		this.ad = ad;
	}

	public EmployeePojoClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_designation() {
		return emp_designation;
	}
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	public AddressClass getAd() {
		return ad;
	}
	public void setAd(AddressClass ad) {
		this.ad = ad;
	}
	@Override
	public String toString() {
		return "EmployeePojoClass [emp_id=" + emp_id + ", emp_name=" + emp_name
				+ ", emp_designation=" + emp_designation + ", ad=" + ad + "]";
	}
	

}


