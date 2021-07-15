<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="h40y.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
//System.out.println("signup cheking!");
String username = request.getParameter("username");
String password = request.getParameter("password");
User user = new User();
boolean isExist = user.isExist(username);
if(isExist){
	request.setAttribute("userNameError", "用户名被占用啦，重新取一个吧！");
	request.getRequestDispatcher("signup.jsp").forward(request, response);
	return;
}else{
	user.regist(username, password);
	session.setAttribute("currentUser", username);
	response.sendRedirect("userpage.html");
	return;
}
%>