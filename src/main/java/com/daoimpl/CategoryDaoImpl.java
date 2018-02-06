package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.model.Category;

@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
    }
	@Transactional
	public void insertCategory(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		
	}
	
	public void getCatByID(String cid) {
		//add today
	}
	public void deleteCategory(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.delete(category);
		session.getTransaction().commit();
	}
}
