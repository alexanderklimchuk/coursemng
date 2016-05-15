package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Parent;

@Repository
public interface IParentDao extends CrudRepository<Parent, Integer> {

}
