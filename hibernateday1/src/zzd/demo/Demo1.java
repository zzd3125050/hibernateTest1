package zzd.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

public class Demo1 {
	@Test
	public void fun1(){
		Configuration cfg = new Configuration();;
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
//		Session session = HibernateSessionFactory.getSession();
		
		User user = new User();
		user.setUsername("王五");
		user.setPassword("wwfaef");
		user.setAddress("天津");
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		
		session.close();
	}
}
