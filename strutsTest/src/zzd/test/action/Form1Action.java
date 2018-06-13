package zzd.test.action;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import zzd.commons.CommonUtils;
import zzd.entity.User;


public class Form1Action extends ActionSupport{
	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> maps = actionContext.getParameters();
		Set<String> keys = maps.keySet();
		for (String string : keys) {
			System.out.println(string);
		}
		for (String key : keys) {
			Object[] obj = (Object[]) maps.get(key);
			System.out.println(Arrays.toString(obj));
		}
		
		return NONE;
	}
	
	public String demo1(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		System.out.println(user);
		return NONE;
	}
	public String fun(){
		System.out.println("lejfljekf");
		return NONE;
	}
}
