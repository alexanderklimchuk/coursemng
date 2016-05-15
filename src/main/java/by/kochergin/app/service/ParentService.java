package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IClientstatusDao;
import by.kochergin.app.dao.IParentDao;
import by.kochergin.app.domain.*;

@Service
public class ParentService extends GenericService<Parent, Integer, IParentDao> {
	@Autowired
	private IParentDao dao;

	@Autowired
	private IClientstatusDao clientStatusDao;

	@PostConstruct
	public void setDao() {
		setDao(dao);
	}

	@Override
	public Parent create(Parent entity) {
		entity.setClientstatus(clientStatusDao.findOne(entity.getClientstatus().getId()));
		return super.create(entity);
	}
}
