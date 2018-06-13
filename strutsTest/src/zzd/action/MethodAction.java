package zzd.action;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport{
	public String add(){
		System.out.println("add.....");
		return NONE;
	}
	
	public String delete(){
		System.out.println("delete......");
		return SUCCESS;
	}
	
	public String update(){
		System.out.println("update......");
		return SUCCESS;
	}
	
	public String query(){
		System.out.println("query......");
		return SUCCESS;
	}
}
