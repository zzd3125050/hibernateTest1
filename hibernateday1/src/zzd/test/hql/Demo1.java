package zzd.test.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.Customer;
import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 对HQL进行学习测试
 * @author zzd
 * 2018年6月7日
 */
public class Demo1 {
	/**
	 * 使用hql查询所有对象
	 * 
	 * 2018年6月7日
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
			
			Query query = session.createQuery("from Customer");//使用"from 实体类"的名称即可
			
			List<Customer> customers = query.list();
			
			for (Customer customer : customers) {
				System.out.println(customer);
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
	 * 使用hql条件查询
	 * 语句写法：from 实体类名称 where 实体类属性名称=? and 实体类属性名称=?...
	 * 			模糊查询：from 实体类名称 where 实体类属性名称="%xxx%"...
	 * 
	 * 2018年6月7日
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
			
			Query query = session.createQuery("from Customer where cid=?");
			query.setParameter(0, 2);
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer);
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
