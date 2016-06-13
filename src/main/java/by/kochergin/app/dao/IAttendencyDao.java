package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Attendency;
@Repository
public interface IAttendencyDao extends CrudRepository<Attendency, Integer> {

}
