/** 
 * com.explitech.jxc.serviceStoreService.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service;

import java.util.List;

import com.explitech.jxc.model.Store;
import com.explitech.jxc.model.StoreExample;

/**
 * @author hwu
 *
 */
public interface StoreService {
	
	int add(Store store);
	int update(Store store);
	int delete(StoreExample example);
	
	Store find(Integer storeId);
	
	int count(StoreExample example);
	List<Store> list(StoreExample example);
	
}
