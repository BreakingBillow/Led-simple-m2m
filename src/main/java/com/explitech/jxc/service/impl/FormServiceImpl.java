/** 
 * com.explitech.jxc.service.implFormServiceImpl.java 2012-8-14 
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

import com.explitech.jxc.dao.FormMapper;
import com.explitech.jxc.model.Form;
import com.explitech.jxc.model.FormExample;
import com.explitech.jxc.service.FormService;

/**
 * @author hwu
 *
 */
public class FormServiceImpl implements FormService{

	@Autowired
	private FormMapper formDao;
	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormService#add(com.explitech.jxc.model.Form)
	 */
	public int add(Form record) {
		// TODO Auto-generated method stub
		return formDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormService#update(com.explitech.jxc.model.Form)
	 */
	public int update(Form record) {
		// TODO Auto-generated method stub
		return formDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormService#delete(com.explitech.jxc.model.FormExample)
	 */
	public int delete(FormExample example) {
		// TODO Auto-generated method stub
		return formDao.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormService#find(java.lang.Integer)
	 */
	public Form find(Integer formId) {
		// TODO Auto-generated method stub
		return formDao.selectByPrimaryKey(formId);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormService#count(com.explitech.jxc.model.FormExample)
	 */
	public int count(FormExample example) {
		// TODO Auto-generated method stub
		return formDao.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormService#list(com.explitech.jxc.model.FormExample)
	 */
	public List<Form> list(FormExample example) {
		// TODO Auto-generated method stub
		return formDao.selectByExample(example);
	}

}
