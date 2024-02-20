//[수강신청 클릭시]
function corRegFn(obj,lno){
	$.ajax({
		url: "cAppCheck",
		type: "post",
		data: "lno="+lno,	//키=값
		success:function(data){
			if(data.trim()=='SUCCESS'){
				alert("수강신청이 완료되었습니다.");
				//중복신청시 배제
				
			}else if(data.trim()=='FAIL'){
				alert("수강신청이 완료되지 않았습니다.");
			}
		},error:function(){
			alert("서버와의 통신에 실패하였습니다.");
		}		
	});
}

//[수강신청 취소시]
function canFn(obj,cno){
	$.ajax({
		url: "cAppCheck",
		type: "post",
		data: "cno="+cno,	//키=값
		success:function(data){
			if(data.trim()=='SUCCESS2'){
				alert("삭제가 완료되었습니다.");
				
			}else if(data.trim()=='FAIL2'){
				alert("삭제가 완료되지 않았습니다.");
			}
		},error:function(){
			alert("서버와의 통신에 실패하였습니다.");
		}		
	});
}