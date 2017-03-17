package com.incidentmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.incidentmanagement.model.User;
import com.incidentmanagement.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User login(String userId, String password) {
		
		User user = null;
		
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			// session.beginTransaction();
			
			Criteria criteria = session.createCriteria(User.class).add(Expression.eq("userId", userId)).add(Expression.eq("password", password));
			
	        List<User> list = criteria.list();
	        if (list.size() > 0) {
	            user = list.get(0);
	        }
	        session.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return user;
	}

}
