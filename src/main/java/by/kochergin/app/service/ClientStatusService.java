package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IClientstatusDao;
import by.kochergin.app.domain.Clientstatus;

@Service
public class ClientStatusService extends GenericService<Clientstatus, Integer, IClientstatusDao> {
	@Autowired
	private IClientstatusDao dao;

	@PostConstruct
	void initDao() {
		setDao(dao);
	}
}
