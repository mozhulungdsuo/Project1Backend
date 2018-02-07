package com.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.backend.dao.UserDao;

import com.backend.model.User;
@Repository
@Service
public class UserDaoImpl implements UserDao {
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
		session.save(user);
		session.getTransaction().commit();
		
	}
	@Transactional
	public void deleteUser(User user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
}
