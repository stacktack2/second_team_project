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
			console.log(1);
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
			console.log(2);
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
			console.log(3);
		}else{
			isSubmit = false;
		}
	}
	
	if(isSubmit){
		let params = $('#searchIdForm').serialize();
		$.ajax({
				url: "findId",
				type: "post",
				data: params,
				success:function(data){
					console.log(data);
				},error:function(){
				}
			});
		
		
		$('#idModal').modal('show');
		$('.modal-body').text("팔로우")
	}else{
		alert("입력값이 유효하지 않습니다.")
	}
	
	
}