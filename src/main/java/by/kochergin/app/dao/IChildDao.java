package by.kochergin.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Child;

@Repository
public interface IChildDao extends JpaRepository<Child, Integer> {

}
