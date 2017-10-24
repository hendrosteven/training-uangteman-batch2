package com.uangteman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uangteman.entity.Category;
import com.uangteman.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
	
	public List<Product> findAll();
	
	@Query("select p from Product p where p.category.id= :id")
	public List<Product> findByCategory(@Param("id") Long id);
	
	@Query("select p from Product p where p.name like :name")
	public List<Product> findByName(@Param("name") String name);
	
	@Query("select p from Product p where p.harga between :min and :max")
	public List<Product> findByPriceRange(@Param("min") double min,
			@Param("max") double max);
}
