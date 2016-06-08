package com.expensemanager.dao.user;

import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import com.expensemanager.dao.DaoImpl;
import com.expensemanager.entities.User;

public class UserDaoImpl extends DaoImpl<Long, User> implements UserDao {
	
	public User getUserWRTUserName(String username) throws TransactionRequiredException{
		String queryString = "SELECT t FROM User t "
				+ "WHERE username = :username";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}
}

