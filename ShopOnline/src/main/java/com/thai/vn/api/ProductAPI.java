package com.thai.vn.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thai.vn.response.Response;
import com.thai.vn.service.ProductService;

@RestController
public class ProductAPI {

	@Autowired
	ProductService productService;
	
	  @GetMapping("/find_all_product")
	  public ResponseEntity<Response> findAll(@RequestParam(name = "page", defaultValue = "1") int page,
			  								  @RequestParam(name = "size", defaultValue = "9") int size,
			  								  @RequestParam(name = "type", defaultValue = "0") int type){
	 
		  
	 return ResponseEntity.ok(productService.findAll(page,size,type));  
	}
	  
	  
}
