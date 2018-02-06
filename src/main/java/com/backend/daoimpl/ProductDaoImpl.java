package com.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.ProductDao;
import com.backend.model.Product;

@Repository
@Service
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
    }
	@Transactional
	public void insertProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		
	}
	@Transactional
	public
	void deleteProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.delete(product);
		session.getTransaction().commit();
	}

}
