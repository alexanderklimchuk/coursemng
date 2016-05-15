package by.kochergin.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import by.kochergin.app.domain.Child;

@Repository
public interface IChildDao extends PagingAndSortingRepository<Child, Integer> {

}
