package HibernateMapping.MappingDemo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestClass {

	public static void main(String[] args) throws HibernateException, MyException {
		// TODO Auto-generated method stub
        
		AddressClass ad1=new AddressClass(10, "Pune", "MH") ;
		EmployeePojoClass emp1=new EmployeePojoClass(25, "Neha", "Trainee Developer", ad1);

		AddressClass ad2=new AddressClass(50, "Mumbai", "MH") ;
		EmployeePojoClass emp2=new EmployeePojoClass(28, "Guru", "Team Leader", ad2);

		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tranc=session.beginTransaction();
		//ad1.setAid(emp1.getEmp_id());
		session.save(emp1);
		session.save(emp2);
		
		
		Query query = session.createQuery("FROM EmployeePojoClass");
	  
		@SuppressWarnings("unchecked")
		List<EmployeePojoClass> list = (List<EmployeePojoClass>) query.getResultList();
	   
	    System.out.println(list);
	    Query query1 = session.createQuery("FROM AddressClass");
	   
		@SuppressWarnings("unchecked")
		List<EmployeePojoClass> list1 = (List<EmployeePojoClass>) query1.getResultList();
	    System.out.println(list1);
	    
		tranc.commit();
	}

}
