/** 
 * com.explitech.jxc.service.implDictionaryServiceImpl.java 2012-8-14 
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

import com.explitech.jxc.dao.DictionaryMapper;
import com.explitech.jxc.model.Dictionary;
import com.explitech.jxc.model.DictionaryExample;
import com.explitech.jxc.service.DictionaryService;

/**
 * @author hwu
 *
 */
public class DictionaryServiceImpl implements DictionaryService{

	@Autowired
	private DictionaryMapper dictionaryDao;
	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.DictionaryService#add(com.explitech.jxc.model.Dictionary)
	 */
	public int add(Dictionary record) {
		// TODO Auto-generated method stub
		return dictionaryDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.DictionaryService#upate(com.explitech.jxc.model.Dictionary)
	 */
	public int upate(Dictionary record) {
		// TODO Auto-generated method stub
		return dictionaryDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.DictionaryService#delete(com.explitech.jxc.model.Dictionary)
	 */
	public int delete(DictionaryExample example) {
		// TODO Auto-generated method stub
		return dictionaryDao.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.DictionaryService#find(java.lang.Integer)
	 */
	public Dictionary find(Integer itemId) {
		// TODO Auto-generated method stub
		return dictionaryDao.selectByPrimaryKey(itemId);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.DictionaryService#count(com.explitech.jxc.model.DictionaryExample)
	 */
	public int count(DictionaryExample example) {
		// TODO Auto-generated method stub
		return dictionaryDao.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.DictionaryService#list(com.explitech.jxc.model.DictionaryExample)
	 */
	public List<Dictionary> list(DictionaryExample example) {
		// TODO Auto-generated method stub
		return dictionaryDao.selectByExample(example);
	}

}
