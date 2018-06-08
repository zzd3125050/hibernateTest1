package zzd.test.hql;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;

import zzd.entity.Customer;
import zzd.entity.LinkMan;
import zzd.hibernate.HibernateSessionFactory;

/**
 * HQL多表连接查询测试
 * @author zzd
 *
 * 2018年6月8日
 *
 */
public class Demo2 {
	/**
	 * 内连接查询
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
			
			Query query = session.createQuery("from Customer c inner join c.setLinkMan");
			List list = query.list();
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
	 * 迫切内连接查询
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
			
			//迫切内连接  fetch 关键字
			Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			List<Customer> list = query.list();
			Set<Customer> cus = new HashSet<Customer>();
			for (Customer customer : list) {
				cus.add(customer);
			}
			for (Customer customer : cus) {
				System.out.println(customer);
				for(LinkMan linkMan:customer.getSetLinkMan()){
					System.out.println(linkMan);
				}
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
	 * 批量抓取
	 * 在配置文件中设置batch-size的值，越大性能越好
	 * customer.hbm.xml  中，在set  中设置batch-size的值
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
			
			//迫切内连接  fetch 关键字
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer);
				Set<LinkMan> setLinkMans = customer.getSetLinkMan();
				for (LinkMan linkMan : setLinkMans) {
					System.out.println(linkMan);
				}
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
