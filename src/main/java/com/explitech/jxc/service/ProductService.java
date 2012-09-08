/** 
 * com.explitech.jxc.serviceProductService.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service;

import java.util.List;

import com.explitech.jxc.model.Product;
import com.explitech.jxc.model.ProductExample;

/**
 * @author hwu
 *
 */
public interface ProductService {
	int add(Product record);
	int update(Product record);
	int delete(ProductExample example);
	
	Product find(Integer productId);
	
	int count(ProductExample example);
	List<Product> list(ProductExample example);
}
