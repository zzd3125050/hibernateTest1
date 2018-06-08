package zzd.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import zzd.entity.Role;
import zzd.entity.User;
import zzd.hibernate.HibernateSessionFactory;

/**
 * 测试多对多方法
 * @author zzd
 *
 * 2018年6月7日
 *
 */
public class TestManyToMayn {
	/**
	 * 测试多对多级联保存
	 * 2018年6月7日
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
			
			User user1 = new User();
			user1.setUsername("龙可减肥");
			user1.setPassword("lkjlkf");
			user1.setAddress("北京");
			
			User user2 = new User();
			user2.setUsername("额老娘");
			user2.setPassword("kjoen");
			user2.setAddress("伤害");
			
			Role role1 = new Role();
			role1.setR_name("经理");
			role1.setR_memo("kj林");
			
			Role role2 = new Role();
			role2.setR_name("扫地");
			role2.setR_memo("扫大街");
			
			Role role3 = new Role();
			role3.setR_name("打杂");
			role3.setR_memo("端茶倒水");
			
			user1.getRoles().add(role1);
			user1.getRoles().add(role2);
			
			user2.getRoles().add(role2);
			user2.getRoles().add(role3);
			
			session.saveOrUpdate(user1);
			session.saveOrUpdate(user2);
			
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
	 * 维护第三张表，为用户添加角色
	 * 2018年6月7日
	 */
	@Test
	public void testAddRole(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 2);
			Role role = session.get(Role.class, 2);
			user.getRoles().add(role);
			
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
	 * 维护第三张表，为用户删除角色
	 * 2018年6月7日
	 */
	@Test
	public void testDeleteRole(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 2);
			Role role = session.get(Role.class, 2);
			user.getRoles().remove(role);
			
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
