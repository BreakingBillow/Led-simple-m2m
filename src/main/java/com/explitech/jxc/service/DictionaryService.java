/** 
 * com.explitech.jxc.serviceDictionaryService.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.service;

import java.util.List;

import com.explitech.jxc.model.Dictionary;
import com.explitech.jxc.model.DictionaryExample;

/**
 * @author hwu
 *
 */
public interface DictionaryService {
	
	int add(Dictionary record);
	int upate(Dictionary record);
	int delete(DictionaryExample example);	
	Dictionary find(Integer itemId);
	
	int count(DictionaryExample example);
	List<Dictionary> list(DictionaryExample example);
}
