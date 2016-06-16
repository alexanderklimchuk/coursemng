package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IAttendencyDao;
import by.kochergin.app.domain.Attendency;

@Service
public class AttendencyService extends GenericService<Attendency, Integer, IAttendencyDao> {

	@Autowired
	private IAttendencyDao dao;

	@PostConstruct
	void initDao() {
		setDao(dao);
	}

	@Override
	public Attendency create(Attendency entity) {
		return super.create(entity);
	}
}
