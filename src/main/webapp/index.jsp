<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

<jsp:include page="/common/include.jsp" flush="true" />
<script type="text/javascript" src="<%=request.getContextPath() %>/include/js/customer/Customer.js"></script>

<script>
jQuery(document).ready(function(){
	$( "#accordion" ).accordion();
						
});

</script>



<title>Main Page</title>
</head>
<body>

<div id="accordion" style="width: 350px;" >
    <h3><a href="#">First Header</a></h3>
    <div>First content</div>
    <h3><a href="#">Second Header</a></h3>
    <div>Second content</div>
</div>

</body>
</html>