package com.dao;

import com.model.Product;

public interface ProductDao {
	public void insertProduct(Product product);
	public void deleteProduct(Product product);
}
