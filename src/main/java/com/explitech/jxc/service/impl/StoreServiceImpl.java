/** 
 * com.explitech.jxc.service.implStoreServiceImpl.java 2012-8-14 
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

import com.explitech.jxc.dao.StoreMapper;
import com.explitech.jxc.model.Store;
import com.explitech.jxc.model.StoreExample;
import com.explitech.jxc.service.StoreService;

/**
 * @author hwu
 *
 */
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper storeDao;
	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.StoreService#add(com.explitech.jxc.model.Store)
	 */
	public int add(Store store) {
		// TODO Auto-generated method stub
		return storeDao.insertSelective(store);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.StoreService#update(com.explitech.jxc.model.Store)
	 */
	public int update(Store store) {
		// TODO Auto-generated method stub
		return storeDao.updateByPrimaryKeySelective(store);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.StoreService#delete(com.explitech.jxc.model.StoreExample)
	 */
	public int delete(StoreExample example) {
		// TODO Auto-generated method stub
		return storeDao.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.StoreService#find(java.lang.Integer)
	 */
	public Store find(Integer storeId) {
		// TODO Auto-generated method stub
		return storeDao.selectByPrimaryKey(storeId);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.StoreService#count(com.explitech.jxc.model.StoreExample)
	 */
	public int count(StoreExample example) {
		// TODO Auto-generated method stub
		return storeDao.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.StoreService#list(com.explitech.jxc.model.StoreExample)
	 */
	public List<Store> list(StoreExample example) {
		// TODO Auto-generated method stub
		return storeDao.selectByExample(example);
	}
	

}
