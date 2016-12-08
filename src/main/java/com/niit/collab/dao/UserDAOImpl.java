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

import com.niit.collab.model.User;
import com.niit.collab.dao.UserDAO;
import com.niit.collab.dao.UserDAOImpl;

@Repository(value="userDAO")
public class UserDAOImpl implements UserDAO {
	
	private static final Logger log= LoggerFactory.getLogger(UserDAOImpl.class);


	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	
	public UserDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(User user) {
		
		log.debug("calling of the method save");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

	@Transactional
	public boolean delete(User user) {
		log.debug("calling of the method delete");
		try {
			sessionFactory.getCurrentSession().delete(user);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	@Transactional
	public List<User> getuser(int id) {
		  String hql = "from User where id= "+ "'"+ id+"'" ;
		  Query query=sessionFactory.getCurrentSession().createQuery(hql);
		  List<User>list= query.list();
		  
		  if(list==null)
		  {
		   return null;
		  }
		  else
		  {
		   return (List<User>) list.get(0);
		  }
		 }
	
	
	
	
	@Transactional
	public List<User> list() {
		log.debug("calling of the method getAllUsers");
		Query c=sessionFactory.getCurrentSession().createQuery("from User");

		List<User> list=c.list();
				
		return list;
	}
	@Transactional
	public User authuser(String username, String password) {
		String hql="from User where username= "+"'"+username+"'"+"and password= "+"'"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list=query.list();
		if(list==null)
		{
			return null;
		}
		else{
			return list.get(0);
		}
		
	}
	@Transactional
	public User logout(int id) {
		String hql = "from User where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
	
	

}
