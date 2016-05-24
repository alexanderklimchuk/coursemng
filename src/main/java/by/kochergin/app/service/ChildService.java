package by.kochergin.app.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IChildDao;
import by.kochergin.app.dao.ICourseDao;
import by.kochergin.app.dao.IParentDao;
import by.kochergin.app.domain.Child;
import by.kochergin.app.domain.Course;
import by.kochergin.app.domain.Parent;

@Service
public class ChildService extends GenericService<Child, Integer, IChildDao> {
	@Autowired
	private IChildDao dao;

	@Autowired
	private IParentDao parentDao;

	@Autowired
	private ICourseDao courseDao;

	@PostConstruct
	void initDao() {
		setDao(dao);
	}

	@Override
	public Child create(Child entity) {
		Parent parent = parentDao.findOne(entity.getParent().getId());
		entity.setParent(parent);
		refreshCourses(entity);
		return super.create(entity);
	}

	@Override
	public Child update(Child entity) {
		Parent parent = parentDao.findOne(entity.getParent().getId());
		entity.setParent(parent);
		refreshCourses(entity);
		return super.update(entity);
	}

	private void refreshCourses(Child entity) {
		Set<Course> courses = new HashSet<Course>();
		for (Course course : entity.getCourses()) {
			courses.add(courseDao.findOne(course.getId()));
		}
		entity.getCourses().clear();
		entity.getCourses().addAll(courses);
	}
}
