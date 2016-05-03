package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;

import by.kochergin.app.domain.User;

public interface IUserDao extends CrudRepository<User, Integer>, IUserDaoCustom {

}
