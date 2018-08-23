
function reBind(){
	
	/*$(document).ready(function(){
		
		$("input.noNull").keyup(function(){
	    	var val = $(this).val();
			if(val==""){
				$(this).parent().children("div").show();
				$(this).css("border","1px solid #FF0000");
				$(this).parent().children("div").addClass("error");
				$(this).parent().children("div").html("不能为空！！");	
			}else{
				$(this).removeAttr("style");
				$(this).parent().children("div").hide();
			}
			
		});
		
		$("input.num").keyup(function () {
	       	var val = $(this).val();
		       	if(!(/^-?\d+(\.\d{1,6})?$/.test(val)) ){
		       		$(this).parent().children("div").show();
					$(this).css("border","1px solid #FF0000");
					$(this).parent().children("div").html("<lable>必须为不超过小数点后六位的数字！！</lable>");	
					checkOk = false;
				}else{
					$(this).removeAttr("style");
					$(this).parent().children("lable").remove();
				}
				
	    });
		
	});*/

		
		
}

reBind();