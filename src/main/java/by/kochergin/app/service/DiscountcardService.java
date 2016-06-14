package by.kochergin.app.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

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

	@Transactional
	public void addPoints(Integer cardId, Integer delta) {
		Discountcard discountCard = dao.findOne(cardId);
		discountCard.addBalance(delta);
		dao.save(discountCard);
	}
}
