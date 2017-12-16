package HibernateMapping.MappingDemo;

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

@Entity
@Table(name = "Emp_1TO1_Mapping")
public class EmployeePojoClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "E_ID")
	int emp_id;
	@Column(name = "Name")
	String emp_name;
	@Column(name = "Designation")
	String emp_designation;
	@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne(mappedBy="AddressClass")
	//Case1:-
	// @PrimaryKeyJoinColumn
	
	/* @PrimaryKeyJoinColumn(name="E_ID", referencedColumnName="a_id")
	 @PrimaryKeyJoinColumns(value = { @PrimaryKeyJoinColumn })*/
	
	//Case2:-
	// @JoinColumn
	//@JoinColumn(name="E_ID")
	
	//Case3:-
	
	/* @JoinTable(
	 name="Joined_Table",
	 joinColumns=
	 @JoinColumn(name="E_ID", referencedColumnName="E_ID"),
	 inverseJoinColumns=
	 @JoinColumn(name="a_id", referencedColumnName="a_id")
	 )*/
	
	@JoinTable(name = "Combined_Table")
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
/*
case 1:-for @PrimarykeyJoinColumn
      =>use to set common primary key value in both the tables(i.e share primary key)
      =>set @OneToOne annotation on associated object.This annoation indicates that there exist one to one association between both tables 
      =>mappedBy attribute of @OneToOne annotation declares that it is dependent on owner entity for mapping.
      =>set cascade attribute with @OneToOne annotation( cascade attribute is used to save associated object while saving main class object)
      =>Set @PrimaryKeyJoinColumn annotation
      =>Set manully primary key of employee table to primary key of address table
   
case 2:-For @joinColumn annotation
      =>set @OneToOne annotation on associated object
      =>set cascade attribute with @OneToOne annotation( cascade attribute is used to save associated object while saving main class object)
      =>Set @JoinColumn annotation on associated object
      =>It has one or more attribute
      =>Set name attribute of @JoinColumn for declares the column in the targeted entity that will be used tojoin
 
case 3:-For @JoinTable annotation
      =>set @OneToOne annotation on associated object
      =>set cascade attribute with @OneToOne annotation( cascade attribute is used to save associated object while saving main class object)
      =>Set @JoinTable annotation
      =>set name attribute value for giving joined table name
*/
