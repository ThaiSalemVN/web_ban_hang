
package com.thai.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thai.vn.model.ProductType;
import com.thai.vn.repository.ProductTypeRepository;
import com.thai.vn.service.ProductTypeService;

/**
 * The Class service
 */
@Service
public class ProductTypeService  {

	@Autowired
	ProductTypeRepository productTypeRepository;

	
	public List<ProductType> findAll() {
		
		return productTypeRepository.findAll();
	}

	public ResponseEntity<Page<ProductType>> findByName(String name, int page, int size){
		try {
			
			Page<ProductType> pageResult = productTypeRepository.findByNameContaining(name,PageRequest.of(page - 1, size));
			
			return new ResponseEntity<Page<ProductType>>(pageResult, HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // error 500
		}	
	};
	
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	



	
}
