
// 유효성 검사
		
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

function register() {
    // 모든 유효성 검사를 수행합니다.
    if (
        checkPosition(pposition) && checkLab(plab) && checkEmail(pemail) && 
        checkPhone(pphone) && checkCall(pcall) && checkAddr(paddr) && checkZipCode(pzipCode)
    ) {
        // 파일 업로드 유효성 검사 및 FormData에 추가
        let photoInput = document.getElementById("photoInput");
        if (photoInput.files.length > 0) {
            let photoFile = photoInput.files[0];
            if (/\.(jpe?g|png)$/i.test(photoFile.name) && photoFile.size <= 100 * 1024 * 1024) {
                // 파일이 유효하면 FormData에 추가
                let formData = new FormData(document.getElementById("profUserAddForm"));
                formData.append("photo", photoFile);
                formData.append("photoName", photoFile.name);
                document.getElementById("profUserAddForm").submit();
            } else {
                alert("이미지 파일은 jpeg, jpg, png 형식이어야 하며, 크기는 10MB 이하이어야 합니다.");
            }
        } else {
            alert("사진을 선택해주세요.");
        }
    }
}