<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="h40y.bean.*,h40y.action.*,java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../../css/indexStyle.css">
		<%
			String user = (String)session.getAttribute("currentUser");
			GenerateBillAction gba = new GenerateBillAction();
			List<BillToUser> lst = gba.generateBill(user);
		%>
	</head>
	<body>
	
		<table class="billtable">
			<tr>
				<th>日期</th>
				<th>收支</th>
				<th>类型</th>
				<th>金额</th>
			</tr>
			<%
				for(BillToUser btu:lst){
					if(btu.gac=="PAYOUT")continue;
					else{
			%>
			<tr>
				<td><%=btu.date %></td>
				<td><%=btu.gac %></td>
				<td><%=btu.type %></td>
				<td><%=btu.value %></td>
			</tr>
			<%}}
			%>
		</table>
		
	</body>
</html>