package com.backend.dao;

import com.backend.model.Product;

public interface ProductDao {
	public void insertProduct(Product product);
	public void deleteProduct(Product product);
}
