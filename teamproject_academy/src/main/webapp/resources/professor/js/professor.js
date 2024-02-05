/**
 * 
 */
 
let today = new Date();   

let year = today.getFullYear(); // 년도
let month = today.getMonth() + 1;  // 월
let date = today.getDate();  // 날짜

document.getElementsByName("attendday").values = year+"/"+month+"/"+date;
 
 $(function() {
  $('input[name="attendday"]').daterangepicker({
    singleDatePicker: true,
    showDropdowns: true,
    minYear: year-10,
    maxYear: year+10,
    locale: {
      format: 'YYYY/M/DD'
    }
  });
});


