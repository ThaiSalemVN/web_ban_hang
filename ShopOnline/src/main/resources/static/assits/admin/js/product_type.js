
var UIController = (function(){
	var DOMString = {
		tbody : "tbody",
			
	};
	
	return {
		displayPrdTypes : function(product_types){
			var tbd = document.querySelector(DOMString.tbody);
			while (tbd.hasChildNodes()) {
		        tbd.removeChild(tbd.firstChild);		       
		    }

		    for (let i = 0; i < product_types.length; i++) {
		        var newRow = tbd.insertRow();

		        var cell0 = newRow.insertCell(0);
		        var cell1 = newRow.insertCell(1);
		        var cell2 = newRow.insertCell(2);
		      
		        cell0.innerHTML = product_types[i].id;
		        cell1.innerHTML = product_types[i].name;
		        cell2.innerHTML = '<input type="checkbox" name="deleteInput" value="Bike">';
		        
		    }
		},
		getDOMString : function(){
			return  DOMString;
		}
		
	}		
})();



var controller = (function(UIctrl){
		
	// set up all event
	var setupEventListener = function(){
		
	};
	
	// Get mapping
	var getCtrl = function(result){
		
		// Display all product type;
		UIctrl.displayPrdTypes(result.content);
		
	    // set up page
		setUpPage(result,name);
		
	};
	
	//set up page
	var setUpPage = function(data, name){
		$('#pagination').twbsPagination({
			totalPages : data.totalPages,
			startPage : data.number + 1,			
			visiblePages : 3,
			hideOnlyOnePage : true,
		}).on('page', function(event, page) {
			getConnection('api/product_type?size=5&page='+ page +'&name='+ name,getCtrl);
		});
	};
	
	return  {
		init: function(){
			getConnection('api/product_type?name=&page=1&size=5',getCtrl);
			setupEventListener();
		}
	}
})(UIController);

controller.init()



