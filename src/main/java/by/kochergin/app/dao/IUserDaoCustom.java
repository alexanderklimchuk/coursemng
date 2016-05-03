package by.kochergin.app.dao;

import by.kochergin.app.domain.User;

public interface IUserDaoCustom {
	
	User findUserByLogin(String login);

}
