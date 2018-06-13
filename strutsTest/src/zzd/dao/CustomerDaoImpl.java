package zzd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.Customer;
import zzd.hibernate.HibernateSessionFactory;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> findAll() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> customers = criteria.list();
			
			tx.commit();
			
			return customers;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
//			session.close();//session自动关闭
//			sessionFactory.close();//sessionFactory不必关闭
		}
		return null;
	}
	
	@Test
	public void fun(){
		Customer c = new Customer();
		c.setcName("lkej");
		c.setcLevel("vvv");
		c.setcMobile("3254234");
		c.setcPhone("345");
		c.setcSource("老金额");
		addCustomer(c);
	}

	public void addCustomer(Customer customer) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			session.save(customer);
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
//			session.close();//session自动关闭
//			sessionFactory.close();//sessionFactory不必关闭
		}
	}
}
