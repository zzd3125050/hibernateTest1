package zzd.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 测试update
 * @author zzd
 *
 * 2018年6月5日
 *
 */
public class Demo3Update {
	@Test
	public void fun1(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1);
		
		user.setUsername("杨靖");
		user.setAddress("小日本");
		session.update(user);
		
		tx.commit();
		
		session.close();
	}
	
	/**
	 * 测试删除
	 * 2018年6月5日
	 */
	@Test
	public void fun2(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 3);
		
		session.delete(user);
		
		tx.commit();
		
		session.close();
	}
	
	/**
	 * 一级缓存特性测试
	 * 2018年6月5日
	 */
	@Test
	public void fun3(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 5);
		
		user.setUsername("列兰妃");
		
		tx.commit();
		
		session.close();
	}
	
	/**
	 * current_session测试
	 * 2018年6月5日
	 */
	@Test
	public void fun4(){
		Session session = null;
		Session session1 = null;
		
		
		session = HibernateSessionFactory.getSession();
//		HibernateSessionFactory.closeSession();
		session1 = HibernateSessionFactory.getSession();
		if(session == session1){
			System.out.println("一样样");
		}else{
			System.out.println("不一样");
		}
	}
}
