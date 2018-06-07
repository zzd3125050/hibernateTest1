package zzd.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.Customer;
import zzd.entity.LinkMan;
import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 测试一对多
 * @author zzd
 *
 * 2018年6月6日
 *
 */
public class TestOneToMany {
	/**
	 * 测试一对多级联保存  复杂保存
	 * 2018年6月6日
	 */
	@Test
	public void testAdd(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setcName("老鹅减肥");
			customer.setcLevel("vip");
			customer.setcSource("北京");
			customer.setcPhone("3333");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setlName("勒戒");
			linkMan.setlGender("女");
			linkMan.setlPhone("89654");
			
			LinkMan link2 = new LinkMan();
			link2.setlName("洗不掉");
			link2.setlGender("男");
			link2.setlPhone("32445465");
			
			//建立联系
			customer.getSetLinkMan().add(linkMan);
			customer.getSetLinkMan().add(link2);
			linkMan.setCustomer(customer);
			link2.setCustomer(customer);
			
			//保存
			session.save(customer);
			session.save(link2);
			session.save(linkMan);
			
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
	 * 级联保存简单写法，只需将联系人对象放入客户的set集合中，保存客户即可
	 * 2018年6月6日
	 */
	@Test
	public void testAdd2(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setcName("南石");
			customer.setcLevel("额驸");
			customer.setcSource("南阳");
			customer.setcPhone("36756");
			
			LinkMan linkMan = new LinkMan();
			linkMan.setlName("傻逼");
			linkMan.setlGender("女");
			linkMan.setlPhone("68321");
			
			LinkMan link2 = new LinkMan();
			link2.setlName("‘胡扯");
			link2.setlGender("男");
			link2.setlPhone("98632145");
			
			//建立联系
			customer.getSetLinkMan().add(linkMan);
			customer.getSetLinkMan().add(link2);
			
			//保存
			session.save(customer);
			
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
	 * 一对多修改操作
	 * 2018年6月6日
	 */
	@Test
	public void testUpdate(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 2);
			LinkMan linkMan = session.get(LinkMan.class, 1);
//			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);
			
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
	 * 一对多级联删除
	 * 2018年6月6日
	 */
	@Test
	public void testDelete(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 1);
			
			session.delete(customer);
			
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
