<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>Dictionary List</title>
</head>
<body>


<s:form action="../dictionary/add.action" theme="simple">
	<s:select 
		list="dictionaryVoList"
		listKey="category"
		listValue="category"
		value="listDefaultValue"
		name="dictionaryVo.category"
	/>

	<s:textfield name="dictionaryVo.itemName" />
<!-- 
	<ul>
		<s:iterator value="dictionaryVoQueryList" >
		<li><s:property value="itemName" /></li>
		</s:iterator>
	</ul>
 -->
 	<s:actionmessage />
	<input type="submit" value="Add"></input>
</s:form>

</body>
</html>