package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;

import by.kochergin.app.domain.Clientstatus;

public interface IClientstatusDao extends CrudRepository<Clientstatus, Integer> {

}
