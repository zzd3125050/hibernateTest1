package zzd.demo;

import java.util.Arrays;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 查询测试
 * @author zzd
 *
 * 2018年6月6日
 *
 */
public class Demo4Query {
	/**
	 * Query方法测试
	 * 2018年6月6日
	 */
	@Test
	public void fun1(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from User");
			
			List<User> users = query.list();
			
			for (User user : users) {
				System.out.println(user);
			}
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
//			session.close();
			sessionFactory.close();
		}
	}
	
	/**
	 * Criteria测试
	 * 2018年6月6日
	 */
	@Test
	public void fun2(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(User.class);
			
			List<User> users = criteria.list();
			
			for (User user : users) {
				System.out.println(user);
			}
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
//			session.close();
			sessionFactory.close();
		}
	}
	
	/**
	 * SQLQuery测试
	 * 2018年6月6日
	 */
	@Test
	public void fun3(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			SQLQuery sqlQuery = session.createSQLQuery("select * from user");
					
//			List<Object[]> users = sqlQuery.list();
//			
//			for (Object[] objects : users) {
//				System.out.println(Arrays.toString(objects));
//			}
			
//			设置返回对象形式
			sqlQuery.addEntity(User.class);
			
			List<User> Users = sqlQuery.list();
			
			for (User user : Users) {
				System.out.println(user);
			}
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
//			session.close();
			sessionFactory.close();
		}
	}
}
