package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;

import by.kochergin.app.domain.Parent;

public interface IParentDao extends CrudRepository<Parent, Integer> {

}
