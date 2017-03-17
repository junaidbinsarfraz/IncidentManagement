package com.incidentmanagement.dao;

import com.incidentmanagement.model.User;

public interface LoginDao {
	
	public User login(String userId, String password);
	
}
