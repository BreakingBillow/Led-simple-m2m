/** 
 * com.explitech.jxc.voFormVo.java 2012-8-14 
 *
 * Copyright 2012 Midtronics, Inc.
 * 14E, Noble Center, No.1006, Fuzhong 3rd Road, Shenzhen(518026), China.
 * 7000 Monroe Street Willowbrook, 1L 60527 U.S.A
 * All right reserved. 
 *
 */
package com.explitech.jxc.vo;

import java.util.List;

import com.explitech.jxc.model.Form;
import com.explitech.jxc.util.DateConver;

/**
 * @author hwu
 *
 */
public class FormVo extends Form {
	
	private List<FormDetailVo> formDetailVoList;
	private String customerName;
	private String formDate;

	public List<FormDetailVo> getFormDetailVoList() {
		return formDetailVoList;
	}

	public void setFormDetailVoList(List<FormDetailVo> formDetailVoList) {
		this.formDetailVoList = formDetailVoList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFormDate() {
		if(this.getInputDate() != null) {
			return formDate = DateConver.dateToStr(this.getInputDate());
		}
		
		return formDate;
	}

	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}
	
	
	
}
