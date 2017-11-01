$().ready(function() {
	$("#card").flip({
	  trigger: 'manual'
	});
	var date_input=$('input[name="date"]'); //our date input has the name "date"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    data_input.datepicker({
      format: 'yyyy/mm/dd',
      container: container,
      todayHighlight: true,
      todayBtn: false,
      autoclose: true,
    })
    $('#datetimepicker1').datepicker();
});


$(".signup_link").click(function() {

	$(".signin_form").css('opacity', '0');
	$(".signup_form").css('opacity', '100');
	
	
	$("#card").flip(true);
	
	return false;
});

$("#unflip-btn").click(function(){
  
	$(".signin_form").css('opacity', '100');
	$(".signup_form").css('opacity', '0');
	
  	$("#card").flip(false);
	
	return false;
	
});