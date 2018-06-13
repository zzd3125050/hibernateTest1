package zzd.test.action;


import com.opensymphony.xwork2.ActionSupport;

import zzd.entity.Book;
import zzd.entity.User;
/**
 * 表达式封装方式
 * 它可以同时封装不同类型的实体类
 * 在表单页面，需要写表达式，类似   user.username    user.password
 * @author zzd
 *
 * 2018年6月12日
 *
 */
public class Form3Action extends ActionSupport {
	private User user;
	private Book book;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String execute(){
		System.out.println("form3");
		System.out.println(user);
		System.out.println(book);
		return NONE;
	}
}
