package by.kochergin.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import by.kochergin.app.domain.User;

public class UserDaoImpl implements IUserDaoCustom {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	IUserDao userDao;

	@Override
	public User findUserByLogin(String login) {
		return null;
	}

}
