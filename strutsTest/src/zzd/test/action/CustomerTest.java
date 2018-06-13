package zzd.test.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzd.commons.CommonUtils;
import zzd.entity.Cust;

public class CustomerTest extends ActionSupport implements ModelDriven<Cust> {
	private Cust cust = new Cust();
	@Override
	public Cust getModel() {
		return cust;
	}
	
	public String execute(){
		System.out.println("执行Model_Driven");
		System.out.println(getModel());
		Cust c = CommonUtils.toBean(ServletActionContext.getRequest().getParameterMap(), Cust.class);
		System.out.println("执行Utils");
		System.out.println(c);
		return NONE;
	}
}
