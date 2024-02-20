
// 유효성 검사
	/* 교수번호 유효성 검사 */
	function checkId(obj){
			let regId = /^\d{7}$/;
			let regRs = regId.test(obj.value); 
			let pidInput = document.getElementById("pid");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pidInput.setCustomValidity("교수번호를 입력해주세요.");
				pidInput.focus();
				pidInput.maxLength = 7;
				pidInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pidInput.setCustomValidity("숫자 7자리를 입력해주세요.");
				pidInput.focus();
				pidInput.maxLength = 7;
				pidInput.style.color = 'red';
				return false;
			}else{
				pidInput.setCustomValidity("");
				pidInput.maxLength = 7;
				pidInput.style.color = 'green';
				return true;
			}
		}
		
		document.getElementById("pid").addEventListener("input", function() {
    		let resultpid = checkId(this);
    		console.log(resultpid);
		});
		
	/* 이름 유효성 검사 */
	function checkName(obj){
			let regId = /^[가-힣a-zA-Z]{2,20}$/;
			let regRs = regId.test(obj.value); 
			let pnameInput = document.getElementById("pname");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pnameInput.setCustomValidity("성명를 입력해주세요.");
				pnameInput.focus();
				pnameInput.maxLength = 20;
				pnameInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pnameInput.setCustomValidity("한글 또는 영문을 2자리 이상 입력해주세요.");
				pnameInput.focus();
				pnameInput.maxLength = 20;
				pnameInput.style.color = 'red';
				return false;
			}else{
				pnameInput.setCustomValidity("");
				pnameInput.maxLength = 20;
				pnameInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpname = checkName(document.getElementById("pname"));
		console.log(resultpname);
		
	/* 주민번호 유효성 검사 */
	function checkRegNo1(obj){
			let regId = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))$/;
			let regRs = regId.test(obj.value); 
			let pregNo1Input = document.getElementById("pregNo1");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pregNo1Input.setCustomValidity("주민번호 앞자리를 입력해주세요.");
				pregNo1Input.focus();
				pregNo1Input.maxLength = 6;
				pregNo1Input.style.color = 'red';
				return false;
			}else if(!regRs){
				pregNo1Input.setCustomValidity("주민번호 앞 6자리를 입력해주세요.");
				pregNo1Input.focus();
				pregNo1Input.maxLength = 6;
				pregNo1Input.style.color = 'red';
				return false;
			}else{
				pregNo1Input.setCustomValidity("");
				pregNo1Input.maxLength = 6;
				pregNo1Input.style.color = 'green';
				return true;
			}
		}
		
		let resultpregNo1 = checkRegNo1(document.getElementById("pregNo1"));
		console.log(resultpregNo1);
		
	function checkRegNo2(obj){
			let regId = /^[1-4]\d{6}$/;
			let regRs = regId.test(obj.value); 
			let pregNo2Input = document.getElementById("pregNo2");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pregNo2Input.setCustomValidity("주민번호 뒷자리를 입력해주세요.");
				pregNo2Input.focus();
				pregNo2Input.maxLength = 7;
				pregNo2Input.style.color = 'red';
				return false;
			}else if(!regRs){
				pregNo2Input.setCustomValidity("주민번호 뒤 7자리를 입력해주세요.");
				pregNo2Input.focus();
				pregNo2Input.maxLength = 7;
				pregNo2Input.style.color = 'red';
				return false;
			}else{
				pregNo2Input.setCustomValidity("");
				pregNo2Input.maxLength = 7;
				pregNo2Input.style.color = 'green';
				return true;
			}
		}
		
		let resultpregNo2 = checkRegNo2(document.getElementById("pregNo2"));
		console.log(resultpregNo2);
		
	/* 생년월일 유효성 검사 */
	function checkBirth(obj){
			let regId = /^(19|20)\d\d(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/; 
			let regRs = regId.test(obj.value); 
			let pbirthInput = document.getElementById("pbirth");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pbirthInput.setCustomValidity("생년월일을 입력해주세요.");
				pbirthInput.focus();
				pbirthInput.maxLength = 8;
				pbirthInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pbirthInput.setCustomValidity("숫자 8자리로 입력해주세요.");
				pbirthInput.focus();
				pbirthInput.maxLength = 8;
				pbirthInput.style.color = 'red';
				return false;
			}else{
				pbirthInput.setCustomValidity("");
				pbirthInput.maxLength = 8;
				pbirthInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpbirth = checkBirth(document.getElementById("pbirth"));
		console.log(resultpbirth);
		
	/* 성별 유효성 검사 */
	function checkGender(pgender){
		if(pgender.value == "" || pgender.value === null || pgender.value === undefined){
			check = false;
			return false;
		}else{
			check = true;
			return true;
		}
	}
	
		let resultpgender = checkGender(document.getElementsByName("pgender"));
		console.log(resultpgender);
	
	/* 직급 유효성 검사 */
	function checkPosition(obj){
			let regId = /^교수$|^[가-힣]+(교수)$/;
			let regRs = regId.test(obj.value); 
			let ppositionInput = document.getElementById("pposition");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				ppositionInput.setCustomValidity("직급을 입력해주세요.");
				ppositionInput.focus();
				ppositionInput.maxLength = 20;
				ppositionInput.style.color = 'red';
				return false;
			}else if(!regRs){
				ppositionInput.setCustomValidity("교수 또는 OO교수로 입력해주세요.");
				ppositionInput.focus();
				ppositionInput.maxLength = 20;
				ppositionInput.style.color = 'red';
				return false;
			}else{
				ppositionInput.setCustomValidity("");
				ppositionInput.maxLength = 20;
				ppositionInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpposition = checkPosition(document.getElementById("pposition"));
		console.log(resultpposition);
		
	/* 대학 유효성 검사 */
	function checkUniv(obj){
			let regId = /^[가-힣A-Za-z]+(대학교|Univ)$/;
			let regRs = regId.test(obj.value); 
			let punivInput = document.getElementById("puniv");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				punivInput.setCustomValidity("대학교를 입력해주세요.");
				punivInput.focus();
				punivInput.maxLength = 40;
				punivInput.style.color = 'red';
				return false;
			}else if(!regRs){
				punivInput.setCustomValidity("OOO대학교 또는 oooUniv로 입력해주세요.");
				punivInput.focus();
				punivInput.maxLength = 40;
				punivInput.style.color = 'red';
				return false;
			}else{
				punivInput.setCustomValidity("");
				punivInput.maxLength = 40;
				punivInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpuniv = checkUniv(document.getElementById("puniv"));
		console.log(resultpuniv);
		
	/* 단과대학 유효성 검사 */
	function checkFaculty(obj){
			let regId = /^[가-힣]+대학$/;
			let regRs = regId.test(obj.value); 
			let pfacultyInput = document.getElementById("pfaculty");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pfacultyInput.setCustomValidity("단과대학을 입력해주세요.");
				pfacultyInput.focus();
				pfacultyInput.maxLength = 40;
				pfacultyInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pfacultyInput.setCustomValidity("OOO대학으로 입력해주세요.");
				pfacultyInput.focus();
				pfacultyInput.maxLength = 40;
				pfacultyInput.style.color = 'red';
				return false;
			}else{
				pfacultyInput.setCustomValidity("");
				pfacultyInput.maxLength = 40;
				pfacultyInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpfaculty = checkFaculty(document.getElementById("pfaculty"));
		console.log(resultpfaculty);
		
	/* 전공 유효성 검사 */
	function checkMajor(obj){
			let regId = /^[가-힣]+학$/;
			let regRs = regId.test(obj.value); 
			let pmajorInput = document.getElementById("pmajor");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pmajorInput.setCustomValidity("전공을 입력해주세요.");
				pmajorInput.focus();
				pmajorInput.maxLength = 40;
				pmajorInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pmajorInput.setCustomValidity("OOO학으로 입력해주세요.");
				pmajorInput.focus();
				pmajorInput.maxLength = 40;
				pmajorInput.style.color = 'red';
				return false;
			}else{
				pmajorInput.setCustomValidity("");
				pmajorInput.maxLength = 40;
				pmajorInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpmajor = checkMajor(document.getElementById("pmajor"));
		console.log(resultpmajor);
		
	/* 학위 유효성 검사 */
	function checkDegree(obj){
			let regId = /^(석사|박사)$/;
			let regRs = regId.test(obj.value); 
			let pdegreeInput = document.getElementById("pdegree");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pdegreeInput.setCustomValidity("학위를 입력해주세요.");
				pdegreeInput.focus();
				pdegreeInput.maxLength = 40;
				pdegreeInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pdegreeInput.setCustomValidity("석사 또는 박사를 입력해주세요.");
				pdegreeInput.focus();
				pdegreeInput.maxLength = 40;
				pdegreeInput.style.color = 'red';
				return false;
			}else{
				pdegreeInput.setCustomValidity("");
				pdegreeInput.maxLength = 40;
				pdegreeInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpdegree = checkDegree(document.getElementById("pdegree"));
		console.log(resultpdegree);
		
	/* 연구실 유효성 검사 */
	function checkLab(obj){
			let regId = /^[0-9a-zA-Z]+호$/;
			let regRs = regId.test(obj.value); 
			let plabInput = document.getElementById("plab");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				plabInput.setCustomValidity("연구실을 입력해주세요.");
				plabInput.focus();
				plabInput.maxLength = 40;
				plabInput.style.color = 'red';
				return false;
			}else if(!regRs){
				plabInput.setCustomValidity("OOO호로 입력해주세요.");
				plabInput.focus();
				plabInput.maxLength = 40;
				plabInput.style.color = 'red';
				return false;
			}else{
				plabInput.setCustomValidity("");
				plabInput.maxLength = 40;
				plabInput.style.color = 'green';
				return true;
			}
		}
		
		let resultplab = checkLab(document.getElementById("plab"));
		console.log(resultplab);
		
	/* 임용일자 유효성 검사 */
	function checkAppointDate(obj){
			let regId = /^(19|20)\d\d(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/; 
			let regRs = regId.test(obj.value); 
			let pappointDateInput = document.getElementById("pappointDate");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pappointDateInput.setCustomValidity("임용일자를 입력해주세요.");
				pappointDateInput.focus();
				pappointDateInput.maxLength = 10;
				pappointDateInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pappointDateInput.setCustomValidity("숫자 8자리로 입력해주세요.");
				pappointDateInput.focus();
				pappointDateInput.maxLength = 10;
				pappointDateInput.style.color = 'red';
				return false;
			}else{
				pappointDateInput.setCustomValidity("");
				pappointDateInput.maxLength = 10;
				pappointDateInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpappointDate = checkAppointDate(document.getElementById("pappointDate"));
		console.log(resultpappointDate);
		
	/* 이메일 유효성 검사 */
	function checkEmail(obj){
			let regId = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/; 
			let regRs = regId.test(obj.value); 
			let pemailInput = document.getElementById("pemail");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pemailInput.setCustomValidity("이메일을 입력해주세요.");
				pemailInput.focus();
				pemailInput.maxLength = 45;
				pemailInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pemailInput.setCustomValidity("이메일 형식에 맞게 입력해주세요.");
				pemailInput.focus();
				pemailInput.maxLength = 45;
				pemailInput.style.color = 'red';
				return false;
			}else{
				pemailInput.setCustomValidity("");
				pemailInput.maxLength = 45;
				pemailInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpemail = checkEmail(document.getElementById("pemail"));
		console.log(resultpemail);
		
	/* 휴대전화번호 유효성 검사 */
	function checkPhone(obj){
			let regId = /^(010|011)\d{3,4}\d{4}$/; 
			let regRs = regId.test(obj.value); 
			let pphoneInput = document.getElementById("pphone");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pphoneInput.setCustomValidity("휴대전화번호를 입력해주세요.");
				pphoneInput.focus();
				pphoneInput.maxLength = 11;
				pphoneInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pphoneInput.setCustomValidity("숫자만 입력해주세요.");
				pphoneInput.focus();
				pphoneInput.maxLength = 11;
				pphoneInput.style.color = 'red';
				return false;
			}else{
				pphoneInput.setCustomValidity("");
				pphoneInput.maxLength = 11;
				pphoneInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpphone = checkPhone(document.getElementById("pphone"));
		console.log(resultpphone);
		
	/* 연구실 전화번호 유효성 검사 */
	function checkCall(obj){
			let regId = /^(0(2|3[1-3]|4[1-4]|5[1-5]|6[1-4]))(\d{3,4})(\d{4})$/;
			let regRs = regId.test(obj.value); 
			let pcallInput = document.getElementById("pcall");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pcallInput.setCustomValidity("연구실 전화번호를 입력해주세요.");
				pcallInput.focus();
				pcallInput.maxLength = 10;
				pcallInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pcallInput.setCustomValidity("지역번호와 숫자만 입력해주세요.");
				pcallInput.focus();
				pcallInput.maxLength = 10;
				pcallInput.style.color = 'red';
				return false;
			}else{
				pcallInput.setCustomValidity("");
				pcallInput.maxLength = 10;
				pcallInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpcall = checkCall(document.getElementById("pcall"));
		console.log(resultpcall);
		
	/* 주소 유효성 검사 */
	function checkAddr(obj){
			let regId = /^[가-힣0-9\s\(\)\-]+$/u;
			let regRs = regId.test(obj.value); 
			let paddrInput = document.getElementById("paddr");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				paddrInput.setCustomValidity("주소를 입력해주세요.");
				paddrInput.focus();
				paddrInput.maxLength = 100;
				paddrInput.style.color = 'red';
				return false;
			}else if(!regRs){
				paddrInput.setCustomValidity("올바르게 입력해주세요.");
				paddrInput.focus();
				paddrInput.maxLength = 100;
				paddrInput.style.color = 'red';
				return false;
			}else{
				paddrInput.setCustomValidity("");
				paddrInput.maxLength = 100;
				paddrInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpaddr = checkAddr(document.getElementById("paddr"));
		console.log(resultpaddr);
		
	/* 우편번호 유효성 검사 */
	function checkZipCode(obj){
			let regId = /^\d{5}$/;
			let regRs = regId.test(obj.value); 
			let pzipCodeInput = document.getElementById("pzipCode");
			
			if(obj.value == "" || obj.value === null || obj.value === undefined){
				pzipCodeInput.setCustomValidity("우편번호를 입력해주세요.");
				pzipCodeInput.focus();
				pzipCodeInput.maxLength = 5;
				pzipCodeInput.style.color = 'red';
				return false;
			}else if(!regRs){
				pzipCodeInput.setCustomValidity("올바르게 입력해주세요.");
				pzipCodeInput.focus();
				pzipCodeInput.maxLength = 5;
				pzipCodeInput.style.color = 'red';
				return false;
			}else{
				pzipCodeInput.setCustomValidity("");
				pzipCodeInput.maxLength = 5;
				pzipCodeInput.style.color = 'green';
				return true;
			}
		}
		
		let resultpzipCode = checkZipCode(document.getElementById("pzipCode"));
		console.log(resultpzipCode);

/*function register() {
    // 모든 유효성 검사를 수행합니다.
    let isValid = true;
    
    isValid = isValid && checkId(document.getElementById("pid"));
    isValid = isValid && checkName(document.getElementById("pname"));
    isValid = isValid && checkRegNo1(document.getElementById("pregNo1"));
    isValid = isValid && checkRegNo2(document.getElementById("pregNo2"));
    isValid = isValid && checkBirth(document.getElementById("pbirth"));
    isValid = isValid && checkGender(document.querySelector('input[name="pgender"]:checked'));
    isValid = isValid && checkPosition(document.getElementById("pposition"));
    isValid = isValid && checkUniv(document.getElementById("puniv"));
    isValid = isValid && checkFaculty(document.getElementById("pfaculty"));
    isValid = isValid && checkMajor(document.getElementById("pmajor"));
    isValid = isValid && checkDegree(document.getElementById("pdegree"));
    isValid = isValid && checkLab(document.getElementById("plab"));
    isValid = isValid && checkAppointDate(document.getElementById("pappointDate"));
    isValid = isValid && checkEmail(document.getElementById("pemail"));
    isValid = isValid && checkPhone(document.getElementById("pphone"));
    isValid = isValid && checkCall(document.getElementById("pcall"));
    isValid = isValid && checkAddr(document.getElementById("paddr"));
    isValid = isValid && checkZipCode(document.getElementById("pzipCode"));
    
    isValid = isValid && displayPhotoPreview(document.getElementById("photoInput"));

    if (isValid) {
        // 모든 유효성 검사가 통과하면 AJAX 호출을 진행합니다.
        let formData = new FormData(document.getElementById("profUserAddForm"));
        $.ajax({
            url: "profUserAdd",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            success: function(data) {
                if (data.trim() == "null") {
                    alert("사용자 정보를 다시 입력해주세요.");
                } else {
                    alert("사용자가 추가되었습니다.");
//                  document.getElementById("profUserAddForm").submit();
                    location.href = "/teamproject_academy/admin/userManage/profUserMgView";
                    console.log(data);
                }
            },
            error: function() {
                // 필요한 경우 AJAX 오류를 처리합니다.
            }
        });
    } else {
        // 유효성 검사에서 실패한 경우, 알림을 표시하거나 필요에 따라 처리할 수 있습니다.
        alert("다시 작성해주시기 바랍니다.");
    }
}*/

function register() {
    // 모든 유효성 검사를 수행합니다.
    if (
        checkId(document.getElementById("pid")) &&
        checkName(document.getElementById("pname")) &&
        checkRegNo1(document.getElementById("pregNo1")) &&
        checkRegNo2(document.getElementById("pregNo2")) &&
        checkBirth(document.getElementById("pbirth")) &&
        checkGender(document.querySelector('input[name="pgender"]:checked')) &&
        checkPosition(document.getElementById("pposition")) &&
        checkUniv(document.getElementById("puniv")) &&
        checkFaculty(document.getElementById("pfaculty")) &&
        checkMajor(document.getElementById("pmajor")) &&
        checkDegree(document.getElementById("pdegree")) &&
        checkLab(document.getElementById("plab")) &&
        checkAppointDate(document.getElementById("pappointDate")) &&
        checkEmail(document.getElementById("pemail")) &&
        checkPhone(document.getElementById("pphone")) &&
        checkCall(document.getElementById("pcall")) &&
        checkAddr(document.getElementById("paddr")) &&
        checkZipCode(document.getElementById("pzipCode"))
    ){
		document.profUserAddForm.submit(true);
	}else{
		alert("사용자 정보를 다시 입력해주세요.");
	}
}