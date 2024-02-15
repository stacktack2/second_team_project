function loginButtonClick(){
	let id = document.loginForm.id.value;
	let pw = document.loginForm.pw.value;
	let isValue = (id == "" || id === undefined || id === null || pw == "" || pw === undefined || pw === null);
	if(!isValue){
		document.loginForm.submit();
	}else{
		alert("아이디나 비밀번호를 입력해 주세요.")
	}
}


function searchId(){
	let type = document.searchIdForm.selectType.value;
	let name = document.searchIdForm.inputName.value;
	let birth = document.searchIdForm.inputBirth.value;
	let phone = document.searchIdForm.inputPhone.value;
	
	let isSubmit = true;
	
	if(name == "" || name === undefined || name === null){
		isSubmit = false;
	}else{
		let regId = /^[가-힣a-zA-Z]$/;
		let regRs = regId.test(name);
		if(!regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(birth == "" || birth === undefined || birth === null){
		isSubmit = false;
	}else{
		let regId = /^(19|20)\d\d(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/;
		let regRs = regId.test(birth);
		if(regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(phone == "" || phone === undefined || phone === null){
		isSubmit = false;
	}else{
		let regId = /^01(0|1|[6-9])[0-9]{3,4}[0-9]{4}$/;
		let regRs = regId.test(phone);
		if(regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(isSubmit){
		let params = $('#searchIdForm').serialize();
		$('#idModal').modal('show');
		$.ajax({
				url: "findId",
				type: "post",
				data: params,
				success:function(data){
					if(data.trim() == "null"){
						$('.modal-body').text("일치하는 아이디가 없습니다.");
					}else{
						$('.modal-body').text("일치하는 아이디는 : '" + data + "' 입니다.");
					}
				},error:function(){
				}
			});
	}else{
		alert("입력값이 유효하지 않습니다.")
	}
	
	
}


function searchPw(){
	let type = document.searchPwForm.type.value;
	let id = document.searchPwForm.id.value;
	let name = document.searchPwForm.name.value;
	let birth = document.searchPwForm.birth.value;
	let phone = document.searchPwForm.phone.value;
	let email = document.searchPwForm.email.value;
	let code = document.searchPwForm.code.value;
	
	let isSubmit = true;
	
	if(id == "" || id === undefined || id === null){
		isSubmit = false;
	}else{
		let regId = /^[a-z][a-z0-9]{3,20}$/g;
		let regRs = regId.test(id);
		if(regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(name == "" || name === undefined || name === null){
		isSubmit = false;
	}else{
		let regId = /^[가-힣a-zA-Z]$/;
		let regRs = regId.test(name);
		if(!regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(birth == "" || birth === undefined || birth === null){
		isSubmit = false;
	}else{
		let regId = /^(19|20)\d\d(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/;
		let regRs = regId.test(birth);
		if(regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(phone == "" || phone === undefined || phone === null){
		isSubmit = false;
	}else{
		let regId = /^01(0|1|[6-9])[0-9]{3,4}[0-9]{4}$/;
		let regRs = regId.test(phone);
		if(regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(email == "" || email === undefined || email === null){
		isSubmit = false;
	}else{
		let regId = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
		let regRs = regId.test(email);
		if(regRs){
		}else{
			isSubmit = false;
		}
	}
	
	if(isSubmit){
		let params = $('#searchPwForm').serialize();
		$('#pwModal').modal('show');
		$.ajax({
				url: "findPw",
				type: "post",
				data: params,
				success:function(data){
					if(data.trim() == "null"){
						$('.modal-body').text("일치하는 계정을 찾을 수 없습니다.");
					}else{
						$('.modal-body').text("새 비밀번호는 : '" + data + "' 입니다.");
					}
				},error:function(){
				}
			});
	}else{
		alert("입력값이 유효하지 않습니다.")
	}
	
	
}