/**
 * 
 */

let today = new Date();

let year = today.getFullYear(); // 년도
/*
let month = today.getMonth() + 1;  // 월
let date = today.getDate();  // 날짜

document.getElementsByName("attendday").values = year + "/" + month + "/" + date;
*/
$(function() {
	$('input[name="attendday"]').daterangepicker({
		singleDatePicker: true,
		showDropdowns: true,
		minYear: year - 10,
		maxYear: year + 10,
		locale: {
			format: 'YYYY/MM/DD'
		}
	});
});

/*취약점- sid를 바꿀수도 있다. 백에서 체크 하면 됨*/
function attendChange(attendno,obj){
	$.ajax({
				url: "attendMgView",
				type: "post",
				data: {attendno:attendno, attendyn:obj.value},
				success:function(data){
					if(data.trim() == "null"){
						alert("변경이 되지 않았습니다.");
					}else if(data.trim() == "1"){
						$(obj).parent().prev().html('출석');
					}else if(data.trim() == "2"){
						$(obj).parent().prev().html('결석');
					}else if(data.trim() == "3"){
						$(obj).parent().prev().html('지각');
					}
				},error:function(){
					alert("변경이 되지 않았습니다.!");
				}
			});
}