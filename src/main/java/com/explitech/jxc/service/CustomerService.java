/** 
 * com.explitech.jxc.serviceCustomerService.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service;

import java.util.List;

import com.explitech.jxc.model.Customer;
import com.explitech.jxc.model.CustomerExample;

/**
 * @author hwu
 *
 */
public interface CustomerService {
	int add(Customer record);
	int update(Customer record);
	int delete(CustomerExample example);
	
	Customer find(Integer customerId);
	
	int count(CustomerExample example);
	List<Customer> list(CustomerExample example);
}
