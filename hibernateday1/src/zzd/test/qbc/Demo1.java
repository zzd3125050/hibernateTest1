package zzd.test.qbc;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import zzd.entity.Customer;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 测试qbc语句的实现
 * 使用qbc时，要操作实体类和属性
 * 
 * QBC语句：
 * Restrictions.eq  等于 =
 * .allEq   使用Map，使用key/value进行多个等于的判断
 * .gt   大于>
 * .ge   大于等于>=
 * .lt   小于<
 * .le   小于等于<=
 * .between   对应sql的between子句
 * .like   对应sql的like子句
 * .in   对应SQL的in子句
 * .and   and关系
 * .or   or关系
 * .SQLRestriction Sql限定查询
 * .asc  根据传入的字段进行升序排序
 * .desc  根据传入的字段进行降序排序
 * 
 * @author zzd
 *
 * 2018年6月8日
 *
 */
public class Demo1 {
	/**
	 * QBC查询所有测试
	 * 2018年6月8日
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
			
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
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
	 * QBC条件查询
	 * 2018年6月8日
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
			
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("cid", 1));
			
			List<Customer> list = criteria.list();
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
	 * 排序查询
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
			
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.addOrder(Order.asc("cName"));
			
			List<Customer> list = criteria.list();
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
	 * 设置分页查询
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
			
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(4);
			
			List<Customer> list = criteria.list();
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
	 * 统计查询
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
			
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.setProjection(Projections.rowCount());
			Object obj = criteria.uniqueResult();
			System.out.println(obj);
			
//			List<Customer> list = criteria.list();
//			for (Customer customer : list) {
//				System.out.println(customer);
//			}
			
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
	 * 离线查询
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
			
//			Criteria criteria = session.createCriteria(Customer.class);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			List<Customer> list = criteria.list();
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
