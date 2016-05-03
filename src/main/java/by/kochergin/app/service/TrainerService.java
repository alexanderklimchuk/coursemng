package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.ITrainerDao;
import by.kochergin.app.domain.*;

@Service
public class TrainerService extends GenericService<Trainer, Integer, ITrainerDao> {
	@Autowired
	private ITrainerDao dao;

	@PostConstruct
	public void setDao() {
		setDao(dao);
	}
}