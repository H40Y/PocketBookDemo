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
        <title>注册</title>
        <script src="./js/inputCheck.js"></script>
        <script src="./js/display.js"></script>
    </head>
    <body>
    	<jsp:useBean id="u" class="h40y.bean.User"/>
        <div class="form-wrapper">
            <div class="header" onmouseover="omiRegist(this)" onmouseout="omoRegist(this)">
                	注册
            </div>
            <form id="registform" name="registForm" action="signupCheck.jsp" method="post" onsubmit="return signupOnSubmit()">
	            <div class="input-wrapper">
	                <div class="border-wrapper">
	                    <input type="text" name="username" id="usname" placeholder="USERNAME" onblur="checkName()">
	                    <div id="namespan" class="gap">${userNameError}</div>
	                </div>
	                <div class="border-wrapper">
	                    <input type="password" name="password" id="pwd" placeholder="PASSWORD" onblur="checkPwd()">
	                    <div id="pwdspan" class="gap"></div>
	                </div>
	                <div class="border-wrapper">
	                    <input type="password" name="confirm" id="cpwd" placeholder="CONFIRM YOUR PASSWORD" onblur="checkConfirm()">
	                    <div id="cpwdspan" class="gap"></div> 
	                </div>
	            </div>
	            <div class="action">
	                <input type="submit" class="loginbtn" value = "Signup">
	            </div>
	    	</form>
        </div>
    </body>
</html>