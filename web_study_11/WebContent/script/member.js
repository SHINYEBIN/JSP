function loginCheck(){
	if(document.frm.userid.value.length == 0){
		alert("아이디를 입력하세요");
		document.frm.userid.focus();
		
		return false;
	}
	
	if(document.frm.pwd.value == ""){
		alert("패스워드는 반드시 입력해야합니다.");
		document.frm.pwd.focus();
		
		return false;
	}
	
	return true;
}


function idCheck(){
	if(document.frm.userid.value.length==""){
		alert("아이디를 입력해주세요");
		document.frm.userid.focus();
		
		return;
	}
	
	var url="idCheck.do?userid="+document.frm.userid.value;	// 부모태그: form의 name인 frm 자식태그:input의 name인 userid
	window.open(url,"_blank_1","toolbar=no,menubar=no,"+"scrollbars=yes,resizable=no,width=450,height=200"); 	// 어떤 창을 하나 띄우겠다. //_blank: 새창 띄우기 //resizable:창사이즈 
	
}

function idok(){
	opener.frm.userid.value=document.frm.userid.value;
	opener.frm.reid.value=document.frm.userid.value;
	self.close(); // 자기 자신을 받는다.
	
}

function joinCheck() {
	if(document.frm.name.value.length ==0){
		alert("이름을 써 주세요.");
		document.frm.name.focus();
		
		return false;
	}
	
	if(document.frm.userid.value.length ==0){
		alert("아이디 써 주세요.");
		document.frm.userid.focus();
		
		return false;
	}
	
	if(document.frm.userid.value.length <4){
		alert("아이디 4글자 이상이어야 합니다.");
		document.frm.userid.focus();
		
		return false;
	}
	
	if(document.frm.pwd.value.length ==""){
		alert("암호는 반드시 입력해야합니다.");
		document.frm.pwd.focus();
		
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("암호가 일치하지 않습니다.");
		document.frm.pwd.focus();
		
		return false;
	}
	
	if(document.frm.reid.value.length == 0){
		alert("중복체크를 하지 않았습니다.");
		document.frm.userid.focus();
		
		return false;
	}
	
	return true;
}
