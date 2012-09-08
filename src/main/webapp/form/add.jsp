<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

<jsp:include page="/common/include.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath() %>/include/js/form/FormDetail.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/include/js/form/Form.js"></script>

<script>
jQuery(document).ready(function(){
		
		var colNames = [
		                "Product Id"
		                ,"Product Name"
		                ,"Product Type"
		                ,"Price"	
		                ,"Quantity"
		                ,"Cost"
		                ,"Operate"
		                ];
		var staticParam = {
						gridTable:"#formDetailList"
						,pageDiv:"pFormDetail"
						,colNames: colNames
						,url: "../product/listJson.action"
		};
		
		var formDetailList = new FormDetail(staticParam);		
		formDetailList.load();
		formDetailList.setEnv();	
		
		var form = new Form(staticParam);
		form.setAddFormEnv();
		
		jQuery("#formDetailList").jqGrid('navGrid','#pFormDetail',{edit:true,add:false,del:false});
		
});

function deleteFormDetailRow(cl) {
	$("#formDetailList").jqGrid('delRowData', cl);
	calculateTotalPrice();
}

function calculateTotalPrice() {
	var theIds = $("#formDetailList").jqGrid("getDataIDs");
	var totalPrice = 0;
	
	for(var i = 0; i < theIds.length; i++){
		var theRowData = $("#formDetailList").jqGrid("getRowData", theIds[i]);
		totalPrice = totalPrice + parseFloat(theRowData['cost']);
	}
	
	$("#formTotalPrice").val(totalPrice);
}

</script>


<title>Add Form</title>
</head>
<body>

<s:form theme="simple" id="addProductFormTable" >

	<s:select list="dictionaryVoProductTypeList" headerKey="-1" headerValue="Select Product Type" listKey="itemId" listValue="itemName" label="Product Type" name="productVo.productTypeId" id="productTypeList" />
	<s:select list="productVoList" headerKey="-1" headerValue="Select Product" listKey="productId" listValue="productName" label="Product List" name="productVo.productId" id="productList" />
	<input type="text" id="productPrice" />
	<input type="text" id="productQuantity" /> 
	<input type="text" id="productCost" />
	<input type="button" value="Add Product" id="btnAddProduct"/>
	
</s:form>


 
<table id="formDetailList" style=" margin-left:auto;margin-right:auto;"  border="0" cellpadding="0"  cellspacing="4" >								
</table>

<div id="pFormDetail">
</div>

<s:select list="dictionaryVoFormTypeList" headerKey="-1" headerValue="Select Customer Type" listKey="itemId" listValue="itemName" name="customerVo.customerTypeId" id="formTypeList" />
<s:select list="customerVoList" headerKey="-1" headerValue="Select Customer" listKey="customerId" listValue="customerName" name="formVo.customerId" id="customerList" />
<input type="text" name="formVo.total"  id="formTotalPrice" value="0" />
<input type="button" id="btnAddSaleForm" value="Add Sale Form" />


</body>
</html>