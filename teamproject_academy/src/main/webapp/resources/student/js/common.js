//[수강신청 클릭시]
function corRegFn(obj,lno){
	$.ajax({
		url: "cAppCheck",
		type: "post",
		data: "lno="+lno,	//키=값
		success:function(data){
			if(data.trim()=='SUCCESS'){
				alert("수강신청이 완료되었습니다.");
			}else if(data.trim()=='FAIL'){
				alert("수강신청이 완료되지 않았습니다.");
			}
		},error:function(){
			alert("서버와의 통신에 실패하였습니다.");
		}		
	});
}