package zzd.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Object username = request.getSession().getAttribute("username");
		if(username != null){
			//说明已经登录
			//作出类似于放行的操作，执行action方法
			return arg0.invoke();
		}else{
			//说明没有登录
			//到result标签中找到login的值，到配置的路径中去
			return "login";			
		}
	}

}
