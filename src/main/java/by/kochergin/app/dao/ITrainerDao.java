package by.kochergin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Trainer;
@Repository
public interface ITrainerDao extends JpaRepository<Trainer, Integer> {

}
