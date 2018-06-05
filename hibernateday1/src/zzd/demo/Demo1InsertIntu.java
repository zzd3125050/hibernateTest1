package zzd.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import zzd.entity.User;
import zzd.entity.UserUUID;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 测试添加数据
 * @author zzd
 *
 * 2018年6月5日
 *
 */
public class Demo1InsertIntu {
	@Test
	public void fun1(){
		Configuration cfg = new Configuration();;
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
//		Session session = HibernateSessionFactory.getSession();
		
		User user = new User();
		user.setUsername("李四");
		user.setPassword("eghrsa");
		user.setAddress("北京");
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = HibernateSessionFactory.getSession();
		UserUUID user = new UserUUID();

		user.setUsername("王五");
		user.setPassword("wwfaef");
		user.setAddress("天津");
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
}
