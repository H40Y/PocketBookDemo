function refresh(){
	gainomo();
	costomo();
	clothomo();
	foodomo();
	homeomo();
	outomo();
	studyomo();
	netomo();
	otheromo();
}

function flush(){
	var info = document.getElementById("confirm");
	var date = document.getElementById("btninfo").value;
	var gacinfo = document.getElementById("gacinfo").value;
	var btninfo = document.getElementById("btninfo").value;
	var money = document.getElementById("money").value;
	switch (btnifo){
	case "1":
		var gac = "收入";
		break;
	case "2":
		var gac = "支出";
		break;
	}
	switch (btnifo){
	case "1":
		var type = "衣";
		break;
	case "2":
		var type = "食";
		break;
	case "3":
		var type = "住";
		break;
	case "4":
		var type = "行";
		break;
	case "5":
		var type = "学";
		break;
	case "6":
		var type = "通讯";
		break;
	case "7":
		var type = "其它";
		break;
	}
	var printInfo = date + "在" +type + "方面" + gac + "了" + money;
	info.innerHTML= printInfo;
}

function gainomi(){
    document.getElementById("gainimg").src="../../images/gain.jpg";
}
function gainomo(){
	var btninfo = document.getElementById("gacinfo").value;
	if (btninfo == "0"){
		return;
	}else{
		document.getElementById("gainimg").src="../../images/gain_w.jpg";
	}
}
function gainoclk(id){
	id.form.gacinfo.value='0';
	refresh();
	flush();
}

function costomi(){
    document.getElementById("costimg").src="../../images/cost.jpg";
}
function costomo(){
	var btninfo = document.getElementById("gacinfo").value;
	if (btninfo == "1"){
		return;
	}else{
		document.getElementById("costimg").src="../../images/cost_w.jpg";
	}
}
function costoclk(id){
	id.form.gacinfo.value='1';
	refresh();
	flush();
}

function clothomi(){
    document.getElementById("clothimg").src="../../images/cloth_w.jpg";
}
function clothomo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "1"){
		return;
	}else{
		document.getElementById("clothimg").src="../../images/cloth.jpg";
	}
}
function clothoclk(id){
	id.form.btninfo.value='1';
	refresh();
	flush();
}

function foodomi(){
    document.getElementById("foodimg").src="../../images/food_w.jpg";
}
function foodomo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "2"){
		return;
	}else{
		document.getElementById("foodimg").src="../../images/food.jpg";
	}
}
function foodoclk(id){
	id.form.btninfo.value='2';
	refresh();
	flush();
}

function homeomi(){
    document.getElementById("homeimg").src="../../images/home_w.jpg";
}
function homeomo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "3"){
		return;
	}else{
		document.getElementById("homeimg").src="../../images/home.jpg";
	}
}
function homeoclk(id){
	id.form.btninfo.value='3';
	refresh();
	flush();
}

function outomi(){
    document.getElementById("outimg").src="../../images/outgoing_w.jpg";
}
function outomo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "4"){
		return;
	}else{
		document.getElementById("outimg").src="../../images/outgoing.jpg";
	}
}
function outoclk(id){
	id.form.btninfo.value='4';
	refresh();
	flush();
}

function studyomi(){
    document.getElementById("studyimg").src="../../images/study_w.jpg";
}
function studyomo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "5"){
		return;
	}else{
		document.getElementById("studyimg").src="../../images/study.jpg";
    }
}
function studyoclk(id){
	id.form.btninfo.value='5';
	refresh();
	flush();
}

function netomi(){
    document.getElementById("netimg").src="../../images/net_w.jpg";
}
function netomo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "6"){
		return;
	}else{
		document.getElementById("netimg").src="../../images/net.jpg";
	}
}
function netoclk(id){
	id.form.btninfo.value='6';
	refresh();
	flush();
}

function otheromi(){
    document.getElementById("otherimg").src="../../images/other_w.jpg";
}
function otheromo(){
	var btninfo = document.getElementById("btninfo").value;
	if (btninfo == "7"){
		return;
	}else{
		document.getElementById("otherimg").src="../../images/other.jpg";
	}
}
function otheroclk(id){
	id.form.btninfo.value='7';
	refresh();
	flush();
}

function recordOnSubmit(){
	var money = document.getElementById("money").value;
	var moneyspan = document.getElementById("moneyspan");
	var reg = /^(\+)?\d+(\.\d+)?$/;
	if(reg.test(money)){
		return true;
	}else{
		moneyspan.innerHTML = "不要乱输哦！";
		return false;
	}
}