package bidiret_mappingdemo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestClass {

	public static void main(String[] args) throws HibernateException, MyException {
		// TODO Auto-generated method stub
        
//		AddressClass ad1=new AddressClass(10, "Pune", "MH") ;
//		EmployeePojoClass emp1=new EmployeePojoClass(1, "Neha", "Trainee Developer", ad1);
		
		EmployeePojoClass emp=new EmployeePojoClass();
		emp.setEmp_id(1);
		emp.setEmp_designation("Java Developer");
		emp.setEmp_name("Smita");
		
		AddressClass ad1=new AddressClass();
		/*
		 * Externally set Employee table primary key to address table primary key
		   ad1.setAid(emp.getEmp_id());
		   emp.setEmp_id(ad1.getAid());
		*/
		
		ad1.setAid(10);
		ad1.setCity("Mumbai");
		ad1.setState("MH");
		
		
		emp.setAd(ad1);
		ad1.setEmp(emp);
		
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tranc=session.beginTransaction();
		session.save(emp);
		
		tranc.commit();
	}

}
