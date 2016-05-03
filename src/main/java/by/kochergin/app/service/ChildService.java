package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IChildDao;
import by.kochergin.app.domain.Child;

@Service
public class ChildService extends GenericService<Child, Integer, IChildDao> {
	@Autowired
	private IChildDao dao;

	@PostConstruct
	void initDao() {
		setDao(dao);
	}

	
}
