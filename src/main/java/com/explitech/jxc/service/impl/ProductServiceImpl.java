/** 
 * com.explitech.jxc.service.implProductServiceImpl.java 2012-8-14 
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

import com.explitech.jxc.dao.ProductMapper;
import com.explitech.jxc.model.Product;
import com.explitech.jxc.model.ProductExample;
import com.explitech.jxc.service.ProductService;

/**
 * @author hwu
 *
 */
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productDao;
	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.ProductService#add(com.explitech.jxc.model.Product)
	 */
	public int add(Product record) {
		// TODO Auto-generated method stub
		return productDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.ProductService#update(com.explitech.jxc.model.Product)
	 */
	public int update(Product record) {
		// TODO Auto-generated method stub
		return productDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.ProductService#delete(com.explitech.jxc.model.ProductExample)
	 */
	public int delete(ProductExample example) {
		// TODO Auto-generated method stub
		return productDao.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.ProductService#find(java.lang.Integer)
	 */
	public Product find(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.selectByPrimaryKey(productId);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.ProductService#count(com.explitech.jxc.model.ProductExample)
	 */
	public int count(ProductExample example) {
		// TODO Auto-generated method stub
		return productDao.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.ProductService#list(com.explitech.jxc.model.ProductExample)
	 */
	public List<Product> list(ProductExample example) {
		// TODO Auto-generated method stub
		return productDao.selectByExample(example);
	}

}
