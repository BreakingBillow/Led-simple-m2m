<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

<jsp:include page="/common/include.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath() %>/include/js/store/Store.js"></script>

<script>
jQuery(document).ready(function(){
	
	
		var colNames = [
		                "Product Id"
		                ,"Product Type Name"
		                ,"Product Name"
		                ,"Price"
		                ,"Quantity"
		                ,"Value"
		                ];
		var staticParam = {
						gridTable:"#storeList"
						,pageDiv:"pStore"
						,colNames: colNames
						,url: "../store/listJson.action"
		};
		
		var storeList = new Store(staticParam);		
		storeList.load();
		storeList.setEnv();				
		
});

</script>



<title>Store List</title>
</head>
<body>


<s:form action="../product/list.action" theme="simple">


		
</s:form>

<table id="storeList" style=" margin-left:auto;margin-right:auto;"  border="0" cellpadding="0"  cellspacing="4" >								
</table>

<div id="pStore">
</div>


</body>
</html>