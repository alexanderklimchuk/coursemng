package by.kochergin.app.service;


import javax.annotation.PostConstruct;

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

}
