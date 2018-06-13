package zzd.dao;

import java.util.List;

import zzd.entity.Customer;

public interface CustomerDao {
	List<Customer> findAll();
}
