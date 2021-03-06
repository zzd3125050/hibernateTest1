package zzd.test.hql;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	/**
	 * 使用order by 进行排序查询
	 * 2018年6月8日
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
			
			Query query = session.createQuery("from Customer order by cid asc"/*desc倒序*/);
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
	
	/**
	 * 分页查询
	 * 2018年6月8日
	 */
	@Test
	public void fun4(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from Customer");
			//设置分页查询开始位置
			query.setFirstResult(3);
			//设置每页记录数
			query.setMaxResults(3);
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
	
	/**
	 * 投影查询
	 * 2018年6月8日
	 */
	@Test
	public void fun5(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("select cName from Customer");
			
			List<Object> list = query.list();
			for (Object object : list) {
				System.out.println(object);
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
	 * hql聚集函数的使用
	 * 2018年6月8日
	 */
	@Test
	public void fun6(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("select count(*) from Customer");
			Object object = query.uniqueResult();
			
			Long obj = (Long) object;//首先要转成Long类型
			int count = obj.intValue();//然后再转换成int类型
			
			System.out.println(count);
			
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
