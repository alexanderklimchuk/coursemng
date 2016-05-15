package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Clientstatus;

@Repository
public interface IClientstatusDao extends CrudRepository<Clientstatus, Integer> {

}
