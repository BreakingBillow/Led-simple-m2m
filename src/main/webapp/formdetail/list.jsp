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
					,url: "../formdetail/listJson.action"
	};
	
	var formDetailList = new FormDetail(staticParam);		
	formDetailList.loadList();
	formDetailList.setEnv();	
	
	jQuery("#formDetailList").jqGrid('navGrid','#pFormDetail',{edit:true,add:false,del:false});
	
});

</script>

<title>Form Detail List</title>
</head>
<body>

<table id="formList" style=" margin-left:auto;margin-right:auto;"  border="0" cellpadding="0"  cellspacing="4" >								
</table>

<div id="pForm">
</div>


</body>
</html>