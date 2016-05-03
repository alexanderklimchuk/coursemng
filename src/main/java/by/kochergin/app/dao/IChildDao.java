package by.kochergin.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import by.kochergin.app.domain.Child;

public interface IChildDao extends PagingAndSortingRepository<Child, Integer> {

}
