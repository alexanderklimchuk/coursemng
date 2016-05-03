package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Trainer;
@Repository
public interface ITrainerDao extends CrudRepository<Trainer, Integer> {

}
