
/*<script type="text/javascript" th:inline="javascript">
			 const URL = [[@{'/'}]]; 	 
</script>*/
/**
 * Call API
 */

// The GetMapping
 
  var getConnection = (function(path,fnc){
  
	  $.ajax({
		  url : URL + path,
		  type : 'GET',
		  dataType : 'json', // kiểu dữ liệuserver trả về, result là kết quả 
	      success : function(result) {// 200 / result đã chuyển từ json về object    
		   fnc(result);
	    	  
		   },
	      error : function(error) {// 500,400... //console.log(error); //console.log(error.status);
	  
		   } 
	});
  
  });

  

// defind error
var defineError = (function(err){
	if(err.status === 500){
		return "Lỗi sever";
	}
	else if(err.status === 400){
		return "Dữ liệu đầu vào bị sai"; // bad request;
	}
	else if(err.status === 404){
		return "Trang yêu cầu không tồn tại"
	}
	else{
		return "Có gì đó sai";
	}
});

// The GetMapping
var postConnection = (function(){
	
	
	 
});


// The PutMapping
var putConnection = (function(){
	
	
	
});

// The DeleteMapping
var deletConnection = (function(){
	
	
	
});