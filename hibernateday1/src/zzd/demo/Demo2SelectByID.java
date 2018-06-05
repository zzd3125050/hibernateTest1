package zzd.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 测试通过uid查询数据
 * @author zzd
 *
 * 2018年6月5日
 *
 */
public class Demo2SelectByID {
	@Test
	public void fun1(){
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1);
		
		tx.commit();
		
		session.close();
		
		System.out.println(user);
	}
}
