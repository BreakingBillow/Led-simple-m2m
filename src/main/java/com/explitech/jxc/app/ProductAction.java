/** 
 * com.explitech.jxc.appProductAction.java 2012-8-14 
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
import com.explitech.jxc.model.Product;
import com.explitech.jxc.model.ProductExample;
import com.explitech.jxc.service.DictionaryService;
import com.explitech.jxc.service.ProductService;
import com.explitech.jxc.vo.DictionaryVo;
import com.explitech.jxc.vo.ProductVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hwu
 *
 */
public class ProductAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7956582733732814396L;

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ProductService productService;

	private ProductVo productVo;
	private List<ProductVo> productVoList;
	private List<DictionaryVo> dictionaryVoProductTypeList;
	private List<DictionaryVo> dictioanryVoProductColorList;
	
	public String doFind() throws Exception {
		
		
		return SUCCESS;
	}
	
	public String doList() throws Exception {
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
		
//		productVoList = new ArrayList();
//		ProductExample productExample = new ProductExample();
//		com.explitech.jxc.model.ProductExample.Criteria productCriteria = productExample.createCriteria();
//		
//		List<Product> productList = new ArrayList();
//		
//		if(productVo == null) {			
//			 productList = productService.list(productExample);
//		} else {
//			
//			productCriteria.andProductTypeIdEqualTo(productVo.getProductTypeId());
//			productList = productService.list(productExample);			
//		}
//		
//		for(Product pl : productList) {
//			ProductVo tempProductVo = new ProductVo();
//			BeanUtils.copyProperties(pl, tempProductVo);
//			productVoList.add(tempProductVo);
//		}
				
		return SUCCESS;
		
	}
	
	public String doListJson() throws Exception {
		
		productVoList = new ArrayList();
		ProductExample productExample = new ProductExample();
		com.explitech.jxc.model.ProductExample.Criteria productCriteria = productExample.createCriteria();
		
		List<Product> productList = new ArrayList();
		
		if(productVo == null) {			
			 productList = productService.list(productExample);
		} else if(productVo.getProductTypeId() == -1) {
			productList = productService.list(productExample);
		}else {			
			productCriteria.andProductTypeIdEqualTo(productVo.getProductTypeId());
			productList = productService.list(productExample);			
		}
		
		for(Product pl : productList) {
			ProductVo tempProductVo = new ProductVo();
			BeanUtils.copyProperties(pl, tempProductVo);
			productVoList.add(tempProductVo);
		}		
		
		return SUCCESS;
	}
	
	public String doAdd() throws Exception {
		dictionaryVoProductTypeList = new ArrayList();
		dictioanryVoProductColorList = new ArrayList();
		
		DictionaryExample example = new DictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryEqualTo(Constant.PRODUCT_TYPE);
		
		List<Dictionary> dictionaryList = dictionaryService.list(example);
		for(Dictionary di : dictionaryList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			dictionaryVoProductTypeList.add(tempDictionaryVo);
		}
		
		DictionaryExample exampleColor = new DictionaryExample();
		Criteria criteriaColr = exampleColor.createCriteria();
		criteriaColr.andCategoryEqualTo(Constant.PRODUCT_COLOR);
		
		List<Dictionary> dictionaryProductColorList = dictionaryService.list(exampleColor);
		for(Dictionary di : dictionaryProductColorList) {
			DictionaryVo tempDictionaryVo = new DictionaryVo();
			BeanUtils.copyProperties(di, tempDictionaryVo);
			dictioanryVoProductColorList.add(tempDictionaryVo);
		}		
		
		if(productVo == null) {
			return INPUT;
		}
		
		Product product = new Product();
		BeanUtils.copyProperties(productVo, product);
		
		product.setProductTypeName(dictionaryService.find(product.getProductTypeId()).getItemName());
		product.setProductColorName(dictionaryService.find(product.getProductColorId()).getItemName());
		
		productService.add(product);
		
		return SUCCESS;
	}
	
	public String doFindJson() throws Exception {
		
		if(productVo != null) {
			if(productVo.getProductId() != -1) {
				Product tempProduct = productService.find(productVo.getProductId());
				BeanUtils.copyProperties(tempProduct, productVo);
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

	public ProductVo getProductVo() {
		return productVo;
	}

	public void setProductVo(ProductVo productVo) {
		this.productVo = productVo;
	}

	public List<ProductVo> getProductVoList() {
		return productVoList;
	}

	public void setProductVoList(List<ProductVo> productVoList) {
		this.productVoList = productVoList;
	}

	public List<DictionaryVo> getDictionaryVoProductTypeList() {
		return dictionaryVoProductTypeList;
	}

	public void setDictionaryVoProductTypeList(
			List<DictionaryVo> dictionaryVoProductTypeList) {
		this.dictionaryVoProductTypeList = dictionaryVoProductTypeList;
	}

	public List<DictionaryVo> getDictioanryVoProductColorList() {
		return dictioanryVoProductColorList;
	}

	public void setDictioanryVoProductColorList(
			List<DictionaryVo> dictioanryVoProductColorList) {
		this.dictioanryVoProductColorList = dictioanryVoProductColorList;
	}
	
}
