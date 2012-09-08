/** 
 * com.explitech.jxc.serviceFormDetailService.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service;

import java.util.List;

import com.explitech.jxc.model.FormDetail;
import com.explitech.jxc.model.FormDetailExample;



/**
 * @author hwu
 *
 */
public interface FormDetailService {
	int add(FormDetail record);
	int update(FormDetail record);
	int delete(FormDetailExample example);
	FormDetail find(Integer formDetailId);
	
	int count(FormDetailExample example);
	List<FormDetail> list(FormDetailExample example);
	
}
