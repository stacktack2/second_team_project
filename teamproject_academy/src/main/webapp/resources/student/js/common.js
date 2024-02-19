//[수강신청 클릭시]
function regFn(obj,lno){
	$.ajax({
		url: "cAppCheck",
		type: "post",
		data: "lno="+lno,	//키=값
		success:function(data){
			if(data.trim()=='SUCCESS'){
				
			}
		},error:function(){
		}		
	});
}