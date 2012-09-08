/** 
 * com.explitech.jxc.service.implFormDetailServiceImpl.java 2012-8-14 
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

import com.explitech.jxc.dao.FormDetailMapper;
import com.explitech.jxc.model.FormDetail;
import com.explitech.jxc.model.FormDetailExample;
import com.explitech.jxc.service.FormDetailService;

/**
 * @author hwu
 *
 */
public class FormDetailServiceImpl implements FormDetailService {

	@Autowired
	private FormDetailMapper formDetailDao;

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormDetailService#add(com.explitech.jxc.model.FormDetail)
	 */
	public int add(FormDetail record) {
		// TODO Auto-generated method stub
		return formDetailDao.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormDetailService#update(com.explitech.jxc.model.FormDetail)
	 */
	public int update(FormDetail record) {
		// TODO Auto-generated method stub
		return formDetailDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormDetailService#delete(com.explitech.jxc.model.FormDetailExample)
	 */
	public int delete(FormDetailExample example) {
		// TODO Auto-generated method stub
		return formDetailDao.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormDetailService#find(java.lang.Integer)
	 */
	public FormDetail find(Integer formDetailId) {
		// TODO Auto-generated method stub
		return formDetailDao.selectByPrimaryKey(formDetailId);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormDetailService#count(com.explitech.jxc.model.FormDetailExample)
	 */
	public int count(FormDetailExample example) {
		// TODO Auto-generated method stub
		return formDetailDao.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.explitech.jxc.service.FormDetailService#list(com.explitech.jxc.model.FormDetailExample)
	 */
	public List<FormDetail> list(FormDetailExample example) {
		// TODO Auto-generated method stub
		return formDetailDao.selectByExample(example);
	}
	
}
