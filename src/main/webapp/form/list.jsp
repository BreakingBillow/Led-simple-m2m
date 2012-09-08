<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

<jsp:include page="/common/include.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath() %>/include/js/form/Form.js"></script>

<script>
jQuery(document).ready(function(){
	
	
		var colNames = [
		                "Form Id"
		                ,"Form Type Name"
		                ,"Customer Name"
		                ,"Form Date"
		                ,"Total"
		                ];
		var staticParam = {
						gridTable:"#formList"
						,pageDiv:"pForm"
						,colNames: colNames
						,url: "../form/listJson.action"
		};
		
		var formList = new Form(staticParam);		
		formList.load();
		formList.setEnv();				
		
});

</script>



<title>Form List</title>
</head>
<body>


<s:form action="../product/list.action" theme="simple">

	<s:select list="dictionaryVoFormTypeList" listKey="itemId" listValue="itemName" label="Customer Type" name="customerVo.customerTypeId" id="formTypeList" />

<!-- 
	<ul>
		<s:iterator value="productVoList" >
		<li><s:property value="productName" /> | <s:property value="price" /> | <s:property value="productTypeName" /> | <s:property value="productColorName" /></li>
		</s:iterator>
	</ul>
 -->
		<input type="button" value="Query" id="btnQueryForm"></input>
	</s:form>

<table id="formList" style=" margin-left:auto;margin-right:auto;"  border="0" cellpadding="0"  cellspacing="4" >								
</table>

<div id="pForm">
</div>


</body>
</html>