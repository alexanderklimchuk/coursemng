package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IChildDao;
import by.kochergin.app.dao.IParentDao;
import by.kochergin.app.domain.Child;
import by.kochergin.app.domain.Parent;

@Service
public class ChildService extends GenericService<Child, Integer, IChildDao> {
	@Autowired
	private IChildDao dao;
	
	@Autowired
	private IParentDao parentDao;

	@PostConstruct
	void initDao() {
		setDao(dao);
	}
	@Override
	public Child create(Child entity) {
		
		Parent parent = parentDao.findOne(entity.getParent().getId());
		entity.setParent(parent);
		
		return super.create(entity);
	}
	
}
