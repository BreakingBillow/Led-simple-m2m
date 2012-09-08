<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

<jsp:include page="/common/include.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath() %>/include/js/product/Product.js"></script>

<script>
jQuery(document).ready(function(){
	
	
		var colNames = [
		                "Product Name"
		                ,"Product Type"
		                ,"Price"	
		                ,"Color"
		                ,"Description"
		                ];
		var staticParam = {
						gridTable:"#productList"
						,pageDiv:"pProduct"
						,colNames: colNames
						,url: "../product/listJson.action"
		};
		
		var productList = new Product(staticParam);		
		productList.load();
		productList.setEnv();				
		
});

</script>



<title>Product List</title>
</head>
<body>


<s:form action="../product/list.action" theme="simple">

	<s:select list="dictionaryVoProductTypeList" listKey="itemId" listValue="itemName" label="Product Type" name="productVo.productTypeId" id="productTypeList" />

<!-- 
	<ul>
		<s:iterator value="productVoList" >
		<li><s:property value="productName" /> | <s:property value="price" /> | <s:property value="productTypeName" /> | <s:property value="productColorName" /></li>
		</s:iterator>
	</ul>
 -->	
	<input type="button" value="Query" id="btnQueryProduct" ></input>
</s:form>

<table id="productList" style=" margin-left:auto;margin-right:auto;"  border="0" cellpadding="0"  cellspacing="4" >								
</table>

<div id="pProduct">
</div>


</body>
</html>