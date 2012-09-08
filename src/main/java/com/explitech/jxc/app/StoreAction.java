/** 
 * com.explitech.jxc.appStoreAction.java 2012-8-14 
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

import com.explitech.jxc.model.Product;
import com.explitech.jxc.model.Store;
import com.explitech.jxc.model.StoreExample;
import com.explitech.jxc.model.StoreExample.Criteria;
import com.explitech.jxc.service.ProductService;
import com.explitech.jxc.service.StoreService;
import com.explitech.jxc.vo.ProductVo;
import com.explitech.jxc.vo.StoreVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hwu
 *
 */
public class StoreAction extends ActionSupport {

	/**
	 * 
	 */
	@Autowired
	private StoreService serviceService;
	@Autowired
	private ProductService productService;
	
	private static final long serialVersionUID = 1920503043870609492L;

	private List<StoreVo> storeVoList;
	private StoreVo storeVo;

	public String doFind() throws Exception {
		
		
		return SUCCESS;
	}	
	
	
	public String doList() throws Exception {
		
		return SUCCESS;
	}

	
	public String doListJson() throws Exception {
		
		storeVoList = new ArrayList();
		StoreExample storeExample = new StoreExample();
		Criteria storeCriteria = storeExample.createCriteria();
		
		List<Store> storeList = new ArrayList();
		
		storeList = serviceService.list(storeExample);
		
		for(Store sl : storeList) {
			StoreVo tempStoreVo = new StoreVo();
			BeanUtils.copyProperties(sl, tempStoreVo);
			
			Product tempProduct = new Product();
			tempProduct = productService.find(tempStoreVo.getProductId());
			
			ProductVo tempProductVo = new ProductVo();
			BeanUtils.copyProperties(tempProduct, tempProductVo);			
			tempStoreVo.setProductVo(tempProductVo);			
			tempStoreVo.setValue(tempStoreVo.getQuantity() * tempStoreVo.getProductVo().getPrice());
			
			storeVoList.add(tempStoreVo);
		}
		
		return SUCCESS;
	}
	
	public String doAdd() throws Exception {
		
		
		return SUCCESS;
	}
	
	public String doUpdate() throws Exception {
		
		
		return SUCCESS;
	}
	
	
	public String doDelete() throws Exception {
		
		
		return SUCCESS;
	}


	public List<StoreVo> getStoreVoList() {
		return storeVoList;
	}


	public void setStoreVoList(List<StoreVo> storeVoList) {
		this.storeVoList = storeVoList;
	}


	public StoreVo getStoreVo() {
		return storeVo;
	}


	public void setStoreVo(StoreVo storeVo) {
		this.storeVo = storeVo;
	}
	
	
}
