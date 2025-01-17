$(document).ready(function() {
	

	
	
	/*
	 * get cookie name
	 */
	function getCookie(cname) {
		var name = cname + "=";
		var decodedCookie = decodeURIComponent(document.cookie);
		var ca = decodedCookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ') {
				c = c.substring(1);
			}
			if (c.indexOf(name) == 0) {
				return c.substring(name.length, c.length);
			}
		}
		return null;
	}
	
	/*
	 * check cookie
	 */
	
	$('#login').click(function(){
		
		if(getCookie("ck1")===null || getCookie("ck2")===null){ 
			
			var parent = document.getElementById('formLogin');
			while(parent.hasChildNodes()){
				parent.removeChild(parent.firstChild);
			}
			
			parent.innerHTML = "<div class='form-group'>" +
					"<label for='email1'>Email or Phone</label>" +
					" <input type='text' class='form-control' name='email1' id='email1'>" +
					"</div>" +
					"<div class='form-group'>" +
					"<label for='password1'>Password</label> <input type='password'" +
					"class='form-control' name='password1' id='password1' placeholder='Password'>" +
					"</div>" +
					"<div class='form-check'>" +
					"<input id='remember'  type='checkbox' name='remember-me' class='form-check-input' >" +
					"<label class='form-check-label' for='remember-me'>Remember me</label>" +
					"</div>" 
				
		}
		else{
			document.getElementById("remember").checked = true;
		}
		
	});
	
	

	
	/*
	 * change password
	 */
	
	$('#change_password').click(function(){
		var path = url + "customer/change_pw"  ///url trong head.html /muasamtructuyen.com/
		
	$.ajax({
			url : path,
			type : 'PUT',
			dataType : 'json', // kiểu dữ liệu server trả về, result là kết quả
			//contentType: 'application/json',
			//data: JSON.stringify(a),
			data:  {//truyen parram
				"id": change_pw.id.value,
				"password": change_pw.password3.value ,
				"password_new":  change_pw.password_new3.value,
				"comfirm": change_pw.comfirm3.value
			},
			success : function(result) {		
				if(result.status){
					window.sessionStorage.setItem("customer",JSON.stringify(result.data));	
					 document.getElementById("cancel3").click();
				}else{
					document.getElementById("error3").innerHTML = result.message;
				}
			},
			error : function(error) {				
				document.getElementById("error3").innerHTML = "Đổi mật khẩu thất bại";
				/*console.log(error);*/

			}
		});
	
	});
	
	
	
	/*
	 * fill to form update
	 */
	
	$('#open_update').click(function(){
		
		var cumstomer =  JSON.parse(sessionStorage.getItem("customer"));
		
		update_customer.id.value =cumstomer.id;
		update_customer.name.value = cumstomer.name;
		update_customer.phone.value =cumstomer.phone;
		if(cumstomer.gender){
			document.getElementById("nam").checked = true;
		}
		else{
			document.getElementById("nu").checked = true;
		}
		
		update_customer.password.value = cumstomer.password;
		update_customer.email.value = cumstomer.email;
		update_customer.adress.value = cumstomer.adress;
	});
	
	
	
	
	function getform(idform){
		var object = {}; // tạo đối tượng
		var formData = $('#'+idform).serializeArray(); // get các name trong form  thành 1 mảng các đối tượng name và value.	
		$.each(formData, function (i, v) { // vòng for jquery
		        	object[""+v.name+""] = v.value;
		});	
		return object;
	}
	
	
	/*
	 * update Customer
	 */

	$('#update_4').click(function(e){
		
		e.preventDefault(); //chánh submit nhầm url		
		var object = getform('update_form');

        $.ajax({
        	 url:  url + "customer",
             type: 'PUT',
             contentType: 'application/json',
             data: JSON.stringify(object),
             dataType: 'json',
             success: function (result) {
            	 if(result.status){
 					window.sessionStorage.setItem("customer",JSON.stringify(result.data));	
 					 document.getElementById("cancel4").click();
 				}else{
 					document.getElementById("error4").innerHTML = result.message;
 				}
            	 
             },
             error: function (error) {
            	 console.log(error);
            	 document.getElementById("error4").innerHTML = "Cập nhật thất bại";
             }   
        	});
	});
	
	
	/*
	 * insert customer
	 */
	
	$('#register2').click(function(e){	
		e.preventDefault();
		var object = getform('register_form');
	
		 $.ajax({
        	 url:  url + "customer",
             type: 'POST',
             contentType: 'application/json',
             data: JSON.stringify(object),
             dataType: 'json',
             success: function (result) {
            	 if(result.status){
 					window.sessionStorage.setItem("customer",JSON.stringify(result.data));	
 					document.getElementById("customer_name").innerHTML = result.data.name;
 					window.hidden(true);
 					document.getElementById("cancel2").click();
 				}else{
 					document.getElementById("error2").innerHTML = result.message;
 				}
            	 
             },
             error: function (error) {
            	 console.log(error);
            	 document.getElementById("error2").innerHTML = "Đăng ký  thất bại";
             }   
        	});
		
	});
	
	
});