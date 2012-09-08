/** 
 * com.explitech.jxc.appCustomerAction.java 2012-8-14 
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
import com.explitech.jxc.model.Customer;
import com.explitech.jxc.model.CustomerExample;
import com.explitech.jxc.model.Dictionary;
import com.explitech.jxc.model.DictionaryExample;
import com.explitech.jxc.model.DictionaryExample.Criteria;
import com.explitech.jxc.service.CustomerService;
import com.explitech.jxc.service.DictionaryService;
import com.explitech.jxc.vo.CustomerVo;
import com.explitech.jxc.vo.DictionaryVo;
import com.explitech.jxc.vo.FormVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hwu
 *
 */
public class CustomerAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2367290480350071675L;

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private CustomerService customerService;	
	
	private List<CustomerVo> customerVoList;
	private CustomerVo customerVo;
	private FormVo formVo;

	private List<DictionaryVo> dictionaryVoCustomerTypeList;	
	
	
	public String doFind() throws Exception {
		
		
		return SUCCESS;
	}	
	
	
	public String doList() throws Exception {
		dictionaryVoCustomerTypeList = new ArrayList();
		
		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryEqualTo(Constant.CUSTOMER_TYPE);
		
		List<Dictionary> dictionaryList = dictionaryService.list(example);
		for(Dictionary di : dictionaryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			dictionaryVoCustomerTypeList.add(tempDictionaryVo);
		}
		
		return SUCCESS;
	}
	
	public String doListJson() throws Exception {
		
		customerVoList = new ArrayList(); 
		CustomerExample customerExample = new CustomerExample();
		com.explitech.jxc.model.CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
		
		List<Customer> customerList = new ArrayList();

		if(customerVo == null) {
			customerList = customerService.list(customerExample);
		} else {
			customerCriteria.andCustomerTypeIdEqualTo(customerVo.getCustomerTypeId());
			customerList = customerService.list(customerExample);
		}
		
		for(Customer cl : customerList) {
			CustomerVo tempCustomerVo = new CustomerVo();
			BeanUtils.copyProperties(cl, tempCustomerVo);
			customerVoList.add(tempCustomerVo);
		}
				
		return SUCCESS;
	}	

	public String doList4FormJson() throws Exception {
		
		customerVoList = new ArrayList(); 
		CustomerExample customerExample = new CustomerExample();
		com.explitech.jxc.model.CustomerExample.Criteria customerCriteria = customerExample.createCriteria();
		
		List<Customer> customerList = new ArrayList();
		
		if(formVo == null) {
			customerList = customerService.list(customerExample);
		} else {
			if(formVo.getFormTypeName().equals(Constant.SALE)) {
				customerCriteria.andCustomerTypeNameEqualTo(Constant.CLIENT);
				customerList = customerService.list(customerExample);
			} else if(formVo.getFormTypeName().equals(Constant.PURCHASE)){
				customerCriteria.andCustomerTypeNameEqualTo(Constant.SUPPLIER);
				customerList = customerService.list(customerExample);
			} else {
				customerList = customerService.list(customerExample);
			}
		}
		
		for(Customer cl : customerList) {
			CustomerVo tempCustomerVo = new CustomerVo();
			BeanUtils.copyProperties(cl, tempCustomerVo);
			customerVoList.add(tempCustomerVo);
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


	public List<CustomerVo> getCustomerVoList() {
		return customerVoList;
	}


	public void setCustomerVoList(List<CustomerVo> customerVoList) {
		this.customerVoList = customerVoList;
	}


	public CustomerVo getCustomerVo() {
		return customerVo;
	}


	public void setCustomerVo(CustomerVo customerVo) {
		this.customerVo = customerVo;
	}


	public List<DictionaryVo> getDictionaryVoCustomerTypeList() {
		return dictionaryVoCustomerTypeList;
	}


	public void setDictionaryVoCustomerTypeList(
			List<DictionaryVo> dictionaryVoCustomerTypeList) {
		this.dictionaryVoCustomerTypeList = dictionaryVoCustomerTypeList;
	}


	public FormVo getFormVo() {
		return formVo;
	}


	public void setFormVo(FormVo formVo) {
		this.formVo = formVo;
	}
	
	
}
