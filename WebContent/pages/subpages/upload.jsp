<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="h40y.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
String user = (String)session.getAttribute("currentUser");

String billDate = request.getParameter("date");
String gacinfo = request.getParameter("gacinfo");
String btninfo = request.getParameter("btninfo");
String money = request.getParameter("money");

int type = Integer.parseInt(btninfo);
int gac = Integer.parseInt(gacinfo);
float money_f = Float.parseFloat(money);

Bill bill = new Bill(user, type, money_f, billDate, gac);
int res = bill.uploadBill();
if (res == -1){
	request.setAttribute("uploadError", "系统异常，请尝试联系作者");
	request.getRequestDispatcher("userpage.html").forward(request, response);
	return;
}else{
	response.sendRedirect("bill.html");
	return;
}

%>