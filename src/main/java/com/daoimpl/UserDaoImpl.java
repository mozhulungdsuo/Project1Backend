package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Supplier;
import com.model.User;

public class UserDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
    }
	@Transactional
	public void insertUser(User user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		//session.presist();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		
	}
}
