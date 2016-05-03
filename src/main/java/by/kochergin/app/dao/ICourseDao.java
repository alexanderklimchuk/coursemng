package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.*;
@Repository
public interface ICourseDao extends CrudRepository<Course, Integer> {

}
