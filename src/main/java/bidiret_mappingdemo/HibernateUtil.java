package bidiret_mappingdemo;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	public static Configuration con=new Configuration();
	public static SessionFactory sf=null;
	public static SessionFactory getSessionFactory() throws MyException
	{
			if(null==con){
				throw new MyException("Check Configuration file");
			}
			     return sf=con.configure().buildSessionFactory();
				
	}

}
