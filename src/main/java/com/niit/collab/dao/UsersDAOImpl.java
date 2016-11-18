package com.niit.collab.dao;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collab.model.Users;
import com.niit.collab.dao.UsersDAO;
import com.niit.collab.dao.UsersDAOImpl;

@Repository(value="usersDAO")
public class UsersDAOImpl implements UsersDAO {
	
	private static final Logger log= LoggerFactory.getLogger(UsersDAOImpl.class);


	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	
	public UsersDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Users users) {
		
		log.debug("calling of the method save");
		try {
			sessionFactory.getCurrentSession().save(users);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Users users) {
		
		log.debug("calling of the method update");
		try {
			sessionFactory.getCurrentSession().update(users);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	

	@Transactional
	public boolean delete(Users users) {
		log.debug("calling of the method delete");
		try {
			sessionFactory.getCurrentSession().delete(users);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	@Transactional
	public Users get(int userID)
	{
		log.debug("calling of the method save");
		log.debug("userID is :" + userID);
		return (Users) sessionFactory.getCurrentSession().get(Users.class, userID);
	}
	
	
	@Transactional
	public Users validate(int userID, String password)
	{
		log.debug("calling of the method validate");
		log.debug("userID is :" + userID + "' and password ='" +password+ "'");
		
		String hql="from Users where userID='" +userID +" ' and password=' "+password+ "'";
		log.debug("the query is :" +hql);
	     Query query= sessionFactory.getCurrentSession().createQuery(hql);
		return (Users) query.uniqueResult();
	}
	
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Users> getAllUsers() {
		log.debug("calling of the method getAllUsers");
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Users.class);
/*		List<Users> list=c.list();*/
		List<Users> list=c.list()
				;
		return list;
	}  
	

}
