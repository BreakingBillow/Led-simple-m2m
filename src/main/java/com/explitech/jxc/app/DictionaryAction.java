/** 
 * com.explitech.jxc.appDictionaryAction.java 2012-8-20 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.explitech.jxc.common.Constant;
import com.explitech.jxc.model.Dictionary;
import com.explitech.jxc.model.DictionaryExample;
import com.explitech.jxc.model.DictionaryExample.Criteria;
import com.explitech.jxc.service.DictionaryService;
import com.explitech.jxc.vo.DictionaryVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hwu
 *
 */
public class DictionaryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1690006854370004974L;
	
	@Autowired
	private DictionaryService dictionaryService;

	private DictionaryVo dictionaryVo;
	private List<DictionaryVo> dictionaryVoList; 
	private List<DictionaryVo> dictionaryVoQueryList;
	
	private String listDefaultValue;
	
	public String doFind() throws Exception {
				
		return SUCCESS;
	}	
		
	public String doList() throws Exception {
		DictionaryExample example = new DictionaryExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		
		List<Dictionary> dictionaryList = dictionaryService.list(example);
		
		dictionaryVoList = new ArrayList();	
		dictionaryVoQueryList = new ArrayList();	
		
		for(Dictionary di : dictionaryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			
			//filter out distinct category here. Kind of database issue
			
			if(dictionaryVoList.size() < 0) { 
				dictionaryVoList.add(tempDictionaryVo);
				continue;
			}
					
			boolean skipFlag = true;
			for(DictionaryVo div : dictionaryVoList) {
				if(tempDictionaryVo.getCategory().equals(div.getCategory())) {
					skipFlag = false;
					break;
				}
			}
			
			if(skipFlag) {
				dictionaryVoList.add(tempDictionaryVo);
			}
		}		
				
		if(dictionaryVo != null && !dictionaryVo.getCategory().equals(""))
		{
			criteria.andCategoryEqualTo(dictionaryVo.getCategory());
			setListDefaultValue(dictionaryVo.getCategory());
						
		} else {
			criteria.andCategoryEqualTo(dictionaryVoList.get(0).getCategory());
			setListDefaultValue(dictionaryVoList.get(0).getCategory());
		}
		
		List<Dictionary> dictionaryQueryList = dictionaryService.list(example);
		
		for(Dictionary di : dictionaryQueryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);	
			dictionaryVoQueryList.add(tempDictionaryVo);
		}
		
		return SUCCESS;
	}
	
	public String doAdd() throws Exception {
		DictionaryExample example = new DictionaryExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		
		List<Dictionary> dictionaryList = dictionaryService.list(example);		
		
		dictionaryVoList = new ArrayList();	
		for(Dictionary di : dictionaryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			
			//filter out distinct category here. Kind of database issue
			
			if(dictionaryVoList.size() < 0) { 
				dictionaryVoList.add(tempDictionaryVo);
				continue;
			}
					
			boolean skipFlag = true;
			for(DictionaryVo div : dictionaryVoList) {
				if(tempDictionaryVo.getCategory().equals(div.getCategory())) {
					skipFlag = false;
					break;
				}
			}
			
			if(skipFlag) {
				dictionaryVoList.add(tempDictionaryVo);
			}
		}			
		
		if(dictionaryVo == null || dictionaryVo.getItemName().equals("")) {
			return INPUT;
		} else {
			Dictionary dictionary = new Dictionary();
			BeanUtils.copyProperties(dictionaryVo, dictionary);
			
			dictionaryService.add(dictionary);
			
			addActionMessage(dictionary.getCategory() + "--" + dictionary.getItemName() + " Add successufully!");
		}
		
		
		return SUCCESS;
	}
	
	public String doUpdate() throws Exception {
		
		
		return SUCCESS;
	}
	
	
	public String doDelete() throws Exception {
		
		
		return SUCCESS;
	}

	public DictionaryVo getDictionaryVo() {
		return dictionaryVo;
	}

	public void setDictionaryVo(DictionaryVo dictionaryVo) {
		this.dictionaryVo = dictionaryVo;
	}

	public List<DictionaryVo> getDictionaryVoList() {
		return dictionaryVoList;
	}

	public void setDictionaryVoList(List<DictionaryVo> dictionaryVoList) {
		this.dictionaryVoList = dictionaryVoList;
	}

	public String getListDefaultValue() {
		return listDefaultValue;
	}

	public void setListDefaultValue(String listDefaultValue) {
		this.listDefaultValue = listDefaultValue;
	}

	public List<DictionaryVo> getDictionaryVoQueryList() {
		return dictionaryVoQueryList;
	}

	public void setDictionaryVoQueryList(List<DictionaryVo> dictionaryVoQueryList) {
		this.dictionaryVoQueryList = dictionaryVoQueryList;
	}	
	
	
}
