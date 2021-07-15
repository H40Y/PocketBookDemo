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
        <link rel="stylesheet" href="../css/recordStyle.css">
        <script src="../js/recordDisplay.js"></script>
    </head>
    <body>
        <div class="form-wrapper">
            <form class="recordform" name="recordForm" action="upload.jsp" method="POST" onsubmit="return recordOnSubmit()">

                <div class="sepbar">首先选择日期</div>
                <div class="date">
                    <input type="date" id="date" name="date">
                    <div id="datespan" class="gap"></div>
                </div>
                
                <div class="sepbar">其次选择收支</div>
                <input type="hidden" id="gacinfo" name="gacinfo" value=""><!-- 保存收支选项 -->
                <div class="gac">
                    <button type="button"  onclick="gainoclk(this)">
                        <img id="gainimg" src="../../images/gain_w.jpg" onmouseover="gainomi()" onmouseout="gainomo()">
                    </button>
                    <button type="button" onclick="costoclk(this)">
                        <img id="costimg" src="../../images/cost_w.jpg" onmouseover="costomi()" onmouseout="costomo()">
                    </button>
                </div>

                <div class="sepbar">然后选择分类</div>
                <input type="hidden" id="btninfo" name="btninfo" value=""><!-- 保存分类信息 -->
                <div class="catagory">
                    <button type="button" onclick="clothoclk(this)">
                        <img id="clothimg" src="../../images/cloth.jpg" onmouseover="clothomi()" onmouseout="clothomo()">
                    </button>
                    <button type="button" onclick="foodoclk(this)">
                        <img id="foodimg" src="../../images/food.jpg" onmouseover="foodomi()" onmouseout="foodomo()">
                    </button>
                    <button type="button" onclick="homeoclk(this)">
                        <img id="homeimg" src="../../images/home.jpg" onmouseover="homeomi()" onmouseout="homeomo()">
                    </button>
                    <button type="button" onclick="outoclk(this)">
                        <img id="outimg" src="../../images/outgoing.jpg" onmouseover="outomi()" onmouseout="outomo()">
                    </button>
                    <button type="button" onclick="studyoclk(this)">
                        <img id="studyimg" src="../../images/study.jpg" onmouseover="studyomi()" onmouseout="studyomo()">
                    </button>
                    <button type="button" onclick="netoclk(this)">
                        <img id="netimg" src="../../images/net.jpg" onmouseover="netomi()" onmouseout="netomo()">
                    </button>
                    <button type="button" onclick="otheroclk(this)">
                        <img id="otherimg" src="../../images/other.jpg" onmouseover="otheromi()" onmouseout="otheromo()">
                    </button>
                </div>

                <div class="sepbar">最后输入金额</div>
                <div class="input-wrapper">
                    <input type="text" class="money" id="money" name="money">
	                <div id="moneyspan" class="gap">${uploadError}</div>
                </div>
                
                <div class="sepbar">确认后提交哦</div>
                <div class="input-wrapper">
                	<input type="submit" class="submitbtn" value = "提交">
                </div>
            </form>
        </div>
    </body>
</html>