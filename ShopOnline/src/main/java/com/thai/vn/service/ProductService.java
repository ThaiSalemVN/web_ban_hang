package com.thai.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thai.vn.model.Product;
import com.thai.vn.repository.ProductRepository;
import com.thai.vn.response.Response;

@Service
public class ProductService  {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product getOne(int id) {
		
		return productRepository.getOne(id);
	}
	
	
	public Response findAll(int page , int size, int type) {
		Page<Product> products ;
		
		
		if (type == 0)  {
			 products = productRepository.findAll(PageRequest.of(page - 1, size));	
		}
		else {
				
			products = productRepository.findByProductTypeId(type, PageRequest.of(page - 1, size));	
		}
			
		return new Response(null, null, products);
		
	}

	
	public Product findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
