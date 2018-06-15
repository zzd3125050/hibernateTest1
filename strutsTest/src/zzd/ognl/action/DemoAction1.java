package zzd.ognl.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzd.entity.User;

public class DemoAction1 extends ActionSupport implements ModelDriven<User>{
	private List<User> users = new ArrayList<User>();
	public List<User> getUsers() {
		return users;
	}

	private User user = new User();

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public User getModel() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		users.add(user);
		return "success";
	}
	
}
