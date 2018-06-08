package zzd.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.Customer;
import zzd.entity.LinkMan;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 对象导航查询测试
 * @author zzd
 *
 * 2018年6月7日
 *
 */
public class ObjectQueryTest {
	
	@Test
	public void fun1(){
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try{
			sf = HibernateSessionFactory.getSessionFactory();
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 2);
			Set<LinkMan> linkMans = customer.getSetLinkMan();
			for (LinkMan linkMan : linkMans) {
				System.out.println(linkMan);
			}
			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sf.close();
		}
	}
}
