package zzd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zzd.commons.CommonUtils;
import zzd.entity.Customer;
import zzd.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService = new CustomerService();
	
	public String findAll(){
		List<Customer> customers = customerService.findAll();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customers", customers);
		
		return "allCustomers";
	}

	public String toAddPage(){
		return "toAddPage";
	}
	
	public String addCustomer(){
		Customer c = CommonUtils.toBean(ServletActionContext.getRequest().getParameterMap(), Customer.class);
		System.out.println("c       ::"+c);
		System.out.println("customer::"+customer);
//		customerService.addCustomer(customer);
//		return "addSuccess";
		return NONE;
	}

}
