package by.kochergin.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
	
	@PersistenceContext
	private EntityManager em;

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
	public void delete(Integer id) {
		Child child = dao.findOne(id);
		if(child != null){
			child.getAttendencies().clear();
			child.getCourses().clear();
			child.getPayments().clear();
			dao.delete(child);
		}
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
