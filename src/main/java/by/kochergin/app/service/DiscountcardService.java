package by.kochergin.app.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IDiscountcardDao;
import by.kochergin.app.domain.Discountcard;

@Service
public class DiscountcardService extends GenericService<Discountcard, Integer, IDiscountcardDao> {

	@Autowired
	private IDiscountcardDao dao;

	@PostConstruct
	public void init() {
		setDao(dao);
	}
}
