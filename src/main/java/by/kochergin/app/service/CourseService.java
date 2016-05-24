package by.kochergin.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.ICourseDao;
import by.kochergin.app.domain.*;

@Service
public class CourseService extends GenericService<Course, Integer, ICourseDao> {

	@Autowired
	private ICourseDao dao;

	@PostConstruct
	public void init() {
		setDao(dao);
	}

	@Transactional
	public List<Trainer> getTrainersByCourseId(Integer id) {
		return new ArrayList<Trainer>(dao.findOne(id).getTrainers());
	}
	
	@Transactional
	public List<Child> getChildrenByCourseId(Integer id) {
		return new ArrayList<Child>(dao.findOne(id).getChildren());
	}
}
