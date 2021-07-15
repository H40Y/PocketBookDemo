
function checkName(){
	var name = document.getElementById("usname").value;
	var nameSpan = document.getElementById("namespan");
	if(name==""){
		nameSpan.innerHTML = "等等，还没输入呢！";
		return false;
	}else{
		nameSpan.innerHTML = "";
		return true;
	}
}

function checkPwd(){
	var pwd = document.getElementById("pwd").value;
	var pwdSpan = document.getElementById("pwdspan");
	if(pwd==""){
		pwdSpan.innerHTML = "等等，还没输入呢！";
		return false;
	}else{
		pwdSpan.innerHTML = "";
		return true;
	}
}

function loginOnSubmit(){
	var nameCk = checkName();
	var pwdCk = checkPwd();
	if (nameCk && pwdCk){
		return true;
	}else{
		return false;
	}
}

function checkConfirm(){
	var password = document.getElementById("pwd").value;
	var confirm = document.getElementById("cpwd").value;
	var cpwdspan = document.getElementById("cpwdspan");
	if(confirm==""){
		cpwdspan.innerHTML = "等等，还没输入呢！";
		return false;
	}else if (confirm != password){
		cpwdspan.innerHTML = "好像输的不一样哦！";  
		return false;
	}else{
		cpwdspan.innerHTML = "";
		return true;
	}
}

function signupOnSubmit(){
	var nameCk = checkName();
	var pwdCk = checkPwd();
	var cpwCk = checkConfirm();
	if (nameCk && pwdCk && cpwCk){
		return true;
	}else{
		return false;
	}
}