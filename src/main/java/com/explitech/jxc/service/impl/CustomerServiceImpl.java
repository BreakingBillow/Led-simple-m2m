/** 
 * com.explitech.jxc.service.implCustomerServiceImpl.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.explitech.jxc.dao.CustomerMapper;
import com.explitech.jxc.model.Customer;
import com.explitech.jxc.model.CustomerExample;
import com.explitech.jxc.service.CustomerService;

/**
 * @author hwu
 *
 */
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerDao;
	
	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.CustomerService#add(com.explitech.jxc.model.Customer)
	 */
	public int add(Customer record) {
		// TODO Auto-generated method stub
		return customerDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.CustomerService#update(com.explitech.jxc.model.Customer)
	 */
	public int update(Customer record) {
		// TODO Auto-generated method stub
		return customerDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.CustomerService#delete(com.explitech.jxc.model.CustomerExample)
	 */
	public int delete(CustomerExample example) {
		// TODO Auto-generated method stub
		return customerDao.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.CustomerService#find(java.lang.Integer)
	 */
	public Customer find(Integer customerId) {
		// TODO Auto-generated method stub
		return customerDao.selectByPrimaryKey(customerId);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.CustomerService#count(com.explitech.jxc.model.CustomerExample)
	 */
	public int count(CustomerExample example) {
		// TODO Auto-generated method stub
		return customerDao.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.CustomerService#list(com.explitech.jxc.model.CustomerExample)
	 */
	public List<Customer> list(CustomerExample example) {
		// TODO Auto-generated method stub
		return customerDao.selectByExample(example);
	}

}
