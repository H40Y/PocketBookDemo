<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/indexStyle.css">
        <title>轻记账</title>
    </head>
    <body>
        <div class="bar">
            <div class="logo"><a href="index.jsp"><img src="../images/logo.png"></a></div>
            <div class="head"><a href="userpageCheck.jsp"><img src="../images/head_photo.png"></a></div>
        </div>

		<form action="userpageCheck.jsp">
	        <input type="hidden" id="btninfo" name="btninfo" value=""><!-- 保存按钮信息 -->
	        <div class="contents">
	            <button class="record" name="record" onclick="this.form.btninfo.value='1'">
	                    <img src="../images/record.jpg">
	            </button>
	            <button class="bill" name="bill" onclick="this.form.btninfo.value='2'">
	                    <img src="../images/bill1.jpg">
	            </button>
	            <button class="sub" name="statistic" onclick="this.form.btninfo.value='3'">
	                    <img src="../images/statistic.jpg">
	            </button>
	            <button class="sub" name="setting" onclick="this.form.btninfo.value='4'">
	                    <img src="../images/setting.jpg">
	            </button>
	            <button class="sub" name="contact-me" onclick="this.form.btninfo.value='5'">
	                    <img src="../images/contact-me.jpg">
	            </button>
	        </div>
        </form>

        <div class="footer-line"></div>

        <div class="footer">
            Code by : H40Y
        </div>
    </body>
</html>