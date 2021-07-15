<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="h40y.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%
			String user = (String)session.getAttribute("currentUser");
			
			User curUser = new User(user);
			int uid = curUser.getUid();
		%>
	</head>
	<body>
		<body>
        <h1>您好！<%=user%></h1>
        <hr>
        <p>您的UID为：</p>
        <div id="uid"><%=uid%></div>
        <hr>
        <p>本页面待完善，作者快没有时间了，所以你可以选择：</p>
        <button>注销</button>
    </body>
	</body>
</html>