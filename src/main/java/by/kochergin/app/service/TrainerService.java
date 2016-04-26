package by.kochergin.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.TrainerDao;
import by.kochergin.app.domain.*;

@Service
public class TrainerService {
	@Autowired
	private TrainerDao dao;

	public List<Trainer> getTrainers() {
		return (List<Trainer>) dao.findAll();
	}

	public Trainer create(Trainer trainer) {
		Trainer saved = dao.save(trainer);
		return saved;
	}
}
