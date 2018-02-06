package com.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.SupplierDao;
import com.backend.model.Supplier;

@Repository
@Service
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
    public SupplierDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
    }
	@Transactional
	public void insertSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
		
	}
	public void deleteSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.delete(supplier);
		session.getTransaction().commit();
		
	}
}
