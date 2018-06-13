package zzd.service;

import java.util.List;

import zzd.dao.CustomerDaoImpl;
import zzd.entity.Customer;

public class CustomerService {
	private CustomerDaoImpl custDaoImpl = new CustomerDaoImpl();
	
	public List<Customer> findAll(){
		return custDaoImpl.findAll();
	}

	public void addCustomer(Customer customer) {
		custDaoImpl.addCustomer(customer);
	}

}
