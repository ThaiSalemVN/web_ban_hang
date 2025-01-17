package com.thai.vn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thai.vn.model.ProductType;
import com.thai.vn.service.ProductTypeService;

/**
 * The API of productType
 */
@RestController()
@RequestMapping("api/product_type")
public class ProductTypeAPI {

	@Autowired
	ProductTypeService productTypeService;
	
	
	// Phân trang
	@GetMapping(params = {"name", "page", "size"})
	public ResponseEntity<Page<ProductType>> findByName(@RequestParam String name,
														@RequestParam int page,
														@RequestParam int size){
		
		return productTypeService.findByName(name, page, size);
	}
	
	@PostMapping()
	public ResponseEntity<ProductType> save(@RequestBody ProductType newProdcType){
		
		return productTypeService.save(newProdcType);
	}
	
	@PutMapping()
	public ResponseEntity<ProductType> update(@RequestBody ProductType newPrdType){
		
		return productTypeService.update(newPrdType);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody int[] ids){
		
		productTypeService.delete(ids);
	}
}
