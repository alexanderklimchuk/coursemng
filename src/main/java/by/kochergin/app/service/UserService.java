package by.kochergin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IUserDao;
import by.kochergin.app.domain.User;

@Service
public class UserService {
	@Autowired
	IUserDao dao;
	
	public User registerNewUser(User user)
	{
		
		
		return dao.save(user);
	}

}
