/** 
 * com.explitech.jxc.serviceFormService.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service;

import java.util.List;

import com.explitech.jxc.model.Form;
import com.explitech.jxc.model.FormExample;

/**
 * @author hwu
 *
 */
public interface FormService {
	
	int add(Form record);
	int update(Form record);
	int delete(FormExample example);
	
	Form find(Integer formId);
	
	int count(FormExample example);
	List<Form> list(FormExample example);	
}
