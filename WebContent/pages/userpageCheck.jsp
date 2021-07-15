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
if (user == null){
	response.sendRedirect("login.jsp");
	return;
}else {
	String func = request.getParameter("btninfo");
	if (func == null){
		response.sendRedirect("userpage.html");
		return;
	}else{
		switch (func){
		case "1":
			response.sendRedirect("userpage.html");
			return;
		case "2":
			response.sendRedirect("userpage.html");
			return;
		case "3":
			response.sendRedirect("userpage.html");
			return;
		case "4":
			response.sendRedirect("userpage.html");
			return;
		case "5":
			response.sendRedirect("userpage.html");
			return;
		}
	}
}
%>