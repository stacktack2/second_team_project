/* 사진 미리보기 */
function displayPhotoPreview(event) {
        var input = event.target;
        var previewElement = document.getElementById('photoPreview');

        if (input.files && input.files[0]) {
            var reader = new FileReader();
            var file = input.files[0];

            if (/\.(jpe?g|png)$/i.test(file.name)) {
	console.log("확장자가 올바르게 매치");
                reader.onload = function (e) {
                    previewElement.innerHTML = '<img src="' + e.target.result + '" style="width:100%; height:100%;" />';
                }
                reader.readAsDataURL(file);
            } else {
	console.log("이미지 파일이 아님");
                alert("이미지 파일만 업로드 가능합니다.");
                input.value = ''; // 파일 선택을 취소하여 미리 선택한 파일을 업로드하지 않도록 합니다.
                previewElement.innerHTML = ''; // 이미지 미리보기를 초기화합니다.
            }
        } else {
            previewElement.innerHTML = ''; // 이미지 미리보기를 초기화합니다.
        }
}

/* 주소 검색 API */
function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                let addr = ''; // 주소 변수
                let extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    
                    document.getElementById("paddr").value = addr + extraAddr;
                
                } else {
                    document.getElementById("paddr").value = addr + extraAddr;
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('pzipCode').value = data.zonecode;
                document.getElementById("paddr").value = addr + extraAddr + " (상세주소를 입력해주세요)";
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("paddr").focus();
            }
        }).open();
    }
    
function register(){
	let isSubmit = true;
	let params = $('#profUserAddForm').serialize();
	$.ajax({
		url: "profUserAdd",
		type: "post",
		data: params,
		success: function(data){
			if(data.trim() == "null"){
				alert("정보를 다시 입력해주세요.");
			}else{
				alert("사용자가 추가되었습니다.");
				document.getElementById("profUserAddForm").submit();
			}
		}, error: function(){
		}
	});
}

