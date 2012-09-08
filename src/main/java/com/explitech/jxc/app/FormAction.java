/** 
 * com.explitech.jxc.appFormAction.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.explitech.jxc.common.Constant;
import com.explitech.jxc.model.Customer;
import com.explitech.jxc.model.CustomerExample;
import com.explitech.jxc.model.Dictionary;
import com.explitech.jxc.model.DictionaryExample;
import com.explitech.jxc.model.DictionaryExample.Criteria;
import com.explitech.jxc.model.Form;
import com.explitech.jxc.model.FormDetail;
import com.explitech.jxc.model.FormExample;
import com.explitech.jxc.model.Product;
import com.explitech.jxc.model.ProductExample;
import com.explitech.jxc.model.Store;
import com.explitech.jxc.model.StoreExample;
import com.explitech.jxc.service.CustomerService;
import com.explitech.jxc.service.DictionaryService;
import com.explitech.jxc.service.FormDetailService;
import com.explitech.jxc.service.FormService;
import com.explitech.jxc.service.ProductService;
import com.explitech.jxc.service.StoreService;
import com.explitech.jxc.util.DateConver;
import com.explitech.jxc.vo.CustomerVo;
import com.explitech.jxc.vo.DictionaryVo;
import com.explitech.jxc.vo.FormDetailVo;
import com.explitech.jxc.vo.FormVo;
import com.explitech.jxc.vo.ProductVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author hwu
 *
 */
public class FormAction extends ActionSupport implements Preparable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1817897633407877636L;

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private FormService formService;
	@Autowired
	private FormDetailService formDetailService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private StoreService storeService;
		
	private FormVo formVo;
	private List<DictionaryVo> dictionaryVoFormTypeList;
	private List<DictionaryVo> dictionaryVoProductTypeList;
	private List<ProductVo> productVoList;
	private List<CustomerVo> customerVoList;
	private List<FormVo> formVoList;
	
	
	public String doFind() throws Exception {
		
		
		return SUCCESS;
	}	
		
	public String doList() throws Exception {
		dictionaryVoFormTypeList = new ArrayList();
		
		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryEqualTo(Constant.FORM_TYPE);
		
		List<Dictionary> dictionaryList = dictionaryService.list(example);
		for(Dictionary di : dictionaryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			dictionaryVoFormTypeList.add(tempDictionaryVo);
		}
		return SUCCESS;
	}
	
	public String doListJson() throws Exception {
		
		formVoList = new ArrayList();
		FormExample formExample = new FormExample();
		com.explitech.jxc.model.FormExample.Criteria formCriteria = formExample.createCriteria();
		
		List<Form> formList = new ArrayList();
		
		if(formVo == null) {
			formList = formService.list(formExample);
		} else {
			formCriteria.andFormTypeIdEqualTo(formVo.getFormTypeId());
			formList = formService.list(formExample);
		}
		
		for(Form fl : formList) {
			FormVo tempFormVo = new FormVo();
			BeanUtils.copyProperties(fl, tempFormVo);
			
			Customer tempCustomer = new Customer();
			tempCustomer = customerService.find(tempFormVo.getCustomerId());
			
			tempFormVo.setCustomerName(tempCustomer.getCustomerName());
			formVoList.add(tempFormVo);
		}
		
		return SUCCESS;
	}	
	
		
	public String doAdd() throws Exception {
		dictionaryVoProductTypeList = new ArrayList();
		
		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryEqualTo(Constant.PRODUCT_TYPE);
		
		List<Dictionary> dictionaryList = dictionaryService.list(example);
		for(Dictionary di : dictionaryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			dictionaryVoProductTypeList.add(tempDictionaryVo);
		}		
		
		dictionaryVoFormTypeList = new ArrayList();
		
		DictionaryExample example2 = new DictionaryExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andCategoryEqualTo(Constant.FORM_TYPE);
		
		List<Dictionary> dictionaryList2 = dictionaryService.list(example2);
		for(Dictionary di : dictionaryList2) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			dictionaryVoFormTypeList.add(tempDictionaryVo);
		}		
				
		productVoList = new ArrayList();
		ProductExample productExample = new ProductExample();
		com.explitech.jxc.model.ProductExample.Criteria productCriteria = productExample.createCriteria();
		
		List<Product> productList = new ArrayList();
		
		//productCriteria.andProductTypeIdEqualTo(dictionaryVoProductTypeList.get(0).getItemId());
		productList = productService.list(productExample);			
			
		for(Product pl : productList) {
			ProductVo tempProductVo = new ProductVo();
			BeanUtils.copyProperties(pl, tempProductVo);
			productVoList.add(tempProductVo);
		}	
				
		customerVoList = new ArrayList();
		CustomerExample customerExample = new CustomerExample();		
		com.explitech.jxc.model.CustomerExample.Criteria customerCriteria =  customerExample.createCriteria();
		//customerCriteria.andCustomerTypeNameEqualTo(Constant.CLIENT);
		
		List<Customer> customerList = new ArrayList();
		customerList = customerService.list(customerExample);
		for(Customer cl : customerList) {
			CustomerVo tempCustomerVo = new CustomerVo();
			BeanUtils.copyProperties(cl, tempCustomerVo);
			customerVoList.add(tempCustomerVo);
		}
		
		return SUCCESS;
	}
	
	public String doAddJson() throws Exception {
		
		Form form = new Form();		
		BeanUtils.copyProperties(formVo, form);
		
		Date today = DateConver.getNow();
		form.setInputDate(today);
		
		formService.add(form);
		
		for(FormDetailVo fdv : formVo.getFormDetailVoList()) {
			FormDetail tempFormDetail = new FormDetail();
			BeanUtils.copyProperties(fdv, tempFormDetail);
			
			tempFormDetail.setFormId(form.getFormId());
			formDetailService.add(tempFormDetail);
			
			Store tempStore = new Store();			
			tempStore  = storeService.find(tempFormDetail.getProductId());
			
			if(tempStore == null) {
				tempStore = new Store();
				tempStore.setProductId(tempFormDetail.getProductId());
				
					if(form.getFormTypeName().equals(Constant.SALE))
						tempStore.setQuantity(tempFormDetail.getQuantity() * -1);
					else 
						tempStore.setQuantity(tempFormDetail.getQuantity());
				storeService.add(tempStore);
			} else {
				int newQuantity = 0;
				
				if(form.getFormTypeName().equals(Constant.SALE)) {
					newQuantity = tempStore.getQuantity() - tempFormDetail.getQuantity();					
					tempStore.setQuantity(newQuantity);					
				} else { 
					newQuantity = tempStore.getQuantity() + tempFormDetail.getQuantity();
					tempStore.setQuantity(newQuantity);	
				}
				storeService.update(tempStore);
			}
			
		}
		
		return SUCCESS;
	}
	
	
	public String doUpdate() throws Exception {
		
		
		return SUCCESS;
	}
	
	
	public String doDelete() throws Exception {
		
		
		return SUCCESS;
	}



	public List<DictionaryVo> getDictionaryVoFormTypeList() {
		return dictionaryVoFormTypeList;
	}

	public void setDictionaryVoFormTypeList(
			List<DictionaryVo> dictionaryVoFormTypeList) {
		this.dictionaryVoFormTypeList = dictionaryVoFormTypeList;
	}

	public List<ProductVo> getProductVoList() {
		return productVoList;
	}

	public void setProductVoList(List<ProductVo> productVoList) {
		this.productVoList = productVoList;
	}

	public List<CustomerVo> getCustomerVoList() {
		return customerVoList;
	}

	public void setCustomerVoList(List<CustomerVo> customerVoList) {
		this.customerVoList = customerVoList;
	}

	public FormVo getFormVo() {
		return formVo;
	}

	public void setFormVo(FormVo formVo) {
		this.formVo = formVo;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Preparable#prepare()
	 */
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<FormVo> getFormVoList() {
		return formVoList;
	}

	public void setFormVoList(List<FormVo> formVoList) {
		this.formVoList = formVoList;
	}

	public List<DictionaryVo> getDictionaryVoProductTypeList() {
		return dictionaryVoProductTypeList;
	}

	public void setDictionaryVoProductTypeList(
			List<DictionaryVo> dictionaryVoProductTypeList) {
		this.dictionaryVoProductTypeList = dictionaryVoProductTypeList;
	}	
	
	
	
}
