
package com.thai.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thai.vn.exception.BadRequestExc;
import com.thai.vn.exception.InternalServerErrorExc;
import com.thai.vn.exception.NotFoundExc;
import com.thai.vn.model.ProductType;
import com.thai.vn.repository.ProductTypeRepository;

/**
 * The Class service
 */
@Service
public class ProductTypeService {

	@Autowired
	ProductTypeRepository productTypeRepository;

	public List<ProductType> findAll() {

		return productTypeRepository.findAll();
	}
	/*
	 * public ResponseEntity<Page<ProductType>> findByName(String name, int page,
	 * int size){ try {
	 * 
	 * Page<ProductType> pageResult =
	 * productTypeRepository.findByNameContaining(name,PageRequest.of(page - 1,
	 * size));
	 * 
	 * return new ResponseEntity<Page<ProductType>>(pageResult, HttpStatus.OK); }
	 * catch (Exception e) {
	 * 
	 * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // error
	 * 500 } };
	 */

	public ResponseEntity<Page<ProductType>> findByName(String name, int page, int size) {
		Page<ProductType> pageResult = null;

		try {
			pageResult = productTypeRepository.findByNameContaining(name, PageRequest.of(page - 1, size));

		} catch (Exception e) {
			throw new InternalServerErrorExc("Lỗi server");
		}

		return ResponseEntity.ok(pageResult);
	};

	public ResponseEntity<ProductType> save(ProductType newPrdType) {
		ProductType productType = null;

		if (productTypeRepository.findById(newPrdType.getId()).isPresent()) { // check tồn tại
			throw new BadRequestExc("Loại sản phẩm này đã tồn tại!");
		} else {
			try {
				productType = productTypeRepository.save(newPrdType);
			} catch (Exception e) {
				throw new InternalServerErrorExc("Lỗi server!");
			}
		}
		
		return ResponseEntity.ok(productType);
	};

	public ResponseEntity<ProductType> update(ProductType newPrdType) {
		ProductType prdType = null;
		ProductType oldPrdType = productTypeRepository.findById(newPrdType.getId()).orElse(null);

		if (oldPrdType == null) { // check ko tồn tại
			throw new NotFoundExc("Loại sản phẩm không tồn tại!");
		} else {
			try {
				prdType = productTypeRepository.save(newPrdType);
			} catch (Exception e) {
				throw new InternalServerErrorExc("Lỗi server!");
			}
		}

		return ResponseEntity.ok(prdType);
	}

	public void delete(int[] ids) {
		// TODO Auto-generated method stub
	    try {
	    	for (int id : ids) {
	    		productTypeRepository.deleteById(id);    		
			}
		} catch (Exception e) {
			throw new InternalServerErrorExc("Lỗi server!");
		}
       
	}

}
