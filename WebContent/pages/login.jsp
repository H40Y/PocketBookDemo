<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/loginStyle.css">
        <script src="./js/display.js"></script>
        <script src="./js/inputCheck.js"></script>
        <title>登录</title>
    </head>
    <body>
    	<jsp:useBean id="u" class="h40y.bean.User"/>
        <div class="form-wrapper">
            <div class="header" onmouseover="omiLogin(this)" onmouseout="omoLogin(this)">
                	登录
            </div>
            <form id="loginform" name="loginForm" action="loginCheck.jsp" method="post" onsubmit="return loginOnSubmit()">
	            <div class="input-wrapper">
	                <div class="border-wrapper">
	                    <input type="text" name="username" placeholder="USERNAME" id="usname" onblur="checkName()"> 
	                    <div id="namespan" class="gap">${userNameError}</div>
	                </div>
	                <div class="border-wrapper">
	                    <input type="password" name="password" placeholder="PASSWORD" id="pwd" onblur="checkPwd()">
	                    <div id="pwdspan" class="gap">${pwdError}</div>
	                </div>
	            </div>
	            <div class="action">
	                <input type="submit" class="loginbtn" value = "Login">
	            </div>
	            <div class="footer">
	                Do not have account? <a href="signup.jsp">Signup</a>
	            </div>
            </form>
        </div>
    </body>
</html>