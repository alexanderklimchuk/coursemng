package by.kochergin.app.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import by.kochergin.app.domain.*;

@Repository
public class CourseDao extends SimpleJpaRepository<Course, Integer> {

	public CourseDao(Class<Course> domainClass, EntityManager em) {
		super(domainClass, em);
	}
}
