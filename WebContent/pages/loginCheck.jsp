<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="h40y.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
//System.out.println("login cheking!");
String username = request.getParameter("username");
String password = request.getParameter("password");
User user = new User();
boolean isExist = user.isExist(username);
if(!isExist){
	request.setAttribute("userNameError", "没有该用户哦，点击下方注册一个吧！");
	request.getRequestDispatcher("login.jsp").forward(request, response);
	return;
}else {
	boolean isValid = user.login(username, password);
	if(isValid){
		session.setAttribute("currentUser", username);
		response.sendRedirect("userpage.html");
		return;
	}else{
		session.setAttribute("pwdError", "密码输错啦！");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return;
	}
}
%>