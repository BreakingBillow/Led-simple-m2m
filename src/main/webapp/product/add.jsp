<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>Add Product</title>
</head>
<body>


<s:form action="../product/add.action" >
	<s:textfield name="productVo.productName" label="Product Name" />
	<s:textfield name="productVo.price" label="Product Prict" />
	<s:textarea name="productVo.description" label="Product Description" />
	<s:select list="dictionaryVoProductTypeList" listKey="itemId" listValue="itemName" label="Product Type" name="productVo.productTypeId" />
	<s:select list="dictioanryVoProductColorList" listKey="itemId" listValue="itemName" label="Product Color" name="productVo.productColorId" />
	<s:submit value="Add product"/>
	<s:actionmessage />
</s:form>

</body>
</html>