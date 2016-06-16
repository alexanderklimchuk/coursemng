package by.kochergin.app.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.ICourseDao;
import by.kochergin.app.dao.ITrainerDao;
import by.kochergin.app.domain.*;

@Service
@Transactional
public class TrainerService extends GenericService<Trainer, Integer, ITrainerDao> {
	@Autowired
	private ITrainerDao dao;

	@Autowired
	private ICourseDao courseDao;

	@PostConstruct
	public void setDao() {
		setDao(dao);
	}

	@Override
	public Trainer update(Trainer entity) {
		refreshCourses(entity);
		return super.update(entity);
	}

	@Override
	public void delete(Integer id) {
		Trainer trainer = dao.findOne(id);
		trainer.getCourses().clear();
		dao.delete(id);
	}

	@Override
	public Trainer create(Trainer entity) {
		refreshCourses(entity);
		return super.create(entity);
	}

	private void refreshCourses(Trainer entity) {
		Set<Course> courses = new HashSet<Course>();
		for (Course course : entity.getCourses()) {
			courses.add(courseDao.findOne(course.getId()));
		}
		entity.getCourses().clear();
		entity.getCourses().addAll(courses);
	}

}
