package by.kochergin.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.CourseDao;
import by.kochergin.app.domain.*;

@Service
public class CourseService {

	@Autowired
	private CourseDao dao;

	public List<Course> getCourses() {
		return (List<Course>) dao.findAll();
	}

	public CourseDao getDao() {
		return dao;
	}

	public void setDao(CourseDao dao) {
		this.dao = dao;
	}

}
