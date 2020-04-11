package com.thai.vn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.thai.vn.model.ProductType;

/**
 * Class productTypeRepository
 */
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

	Page<ProductType > findByNameContaining(String name, Pageable pageable);
	
}
