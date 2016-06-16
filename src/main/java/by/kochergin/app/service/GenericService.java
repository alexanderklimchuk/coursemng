package by.kochergin.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public class GenericService<T, ID extends Serializable, DAO extends CrudRepository<T, ID>> {

	private DAO dao;

	public T get(ID id) {
		return dao.findOne(id);
	}

	public T create(T entity) {
		return dao.save(entity);
	}

	public T update(T entity) {
		return dao.save(entity);
	}

	public void delete(ID id) {
		dao.delete(id);
	}
	
	public void delete(T entity) {
		dao.delete(entity);
	}

	public List<T> getAll() {
		return (List<T>) dao.findAll();
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
}
