package by.kochergin.app.dao;

import org.springframework.data.repository.CrudRepository;

import by.kochergin.app.domain.Payment;

public interface IPaymentDao extends CrudRepository<Payment, Integer> {

}
