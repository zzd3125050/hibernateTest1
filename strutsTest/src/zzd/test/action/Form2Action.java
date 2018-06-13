package zzd.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzd.entity.Cust;
import zzd.entity.User;

/**
 * 模型驱动封装实体类
 * 每次只能封装一种类型的实体类
 * 要实现ModelDriven<T>的接口
 * @author zzd
 *
 * 2018年6月12日
 *
 */
public class Form2Action extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String execute(){
		System.out.println("form2");
		System.out.println(user);
		
		return NONE;
	}
}
