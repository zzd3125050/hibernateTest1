package zzd.service;

import java.util.List;

import zzd.dao.CustomerDaoImpl;
import zzd.entity.Customer;
import zzd.entity.User;

public class CustomerService {
	private CustomerDaoImpl custDaoImpl = new CustomerDaoImpl();
	
	public List<Customer> findAll(){
		return custDaoImpl.findAll();
	}

	public void addCustomer(Customer customer) {
		custDaoImpl.addCustomer(customer);
	}

	public boolean checkUser(User user) {
		if(user.getUsername().trim().equals("zzd") && user.getPassword().trim().equals("123")){
			return true;
		}else{
			return false;
		}
	}
}
