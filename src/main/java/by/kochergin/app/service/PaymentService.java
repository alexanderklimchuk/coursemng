package by.kochergin.app.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IDiscountcardDao;
import by.kochergin.app.dao.IParentDao;
import by.kochergin.app.dao.IPaymentDao;
import by.kochergin.app.domain.Discountcard;
import by.kochergin.app.domain.Payment;

@Service
public class PaymentService extends GenericService<Payment, Integer, IPaymentDao> {

	@Autowired
	private IPaymentDao dao;

	@Autowired
	private IParentDao parentDao;

	@Autowired
	private IDiscountcardDao discountCardDao;

	@PostConstruct
	public void setDao() {
		setDao(dao);
	}

	@Override
	public Payment create(Payment entity) {
		entity.setDate(new Date());
		Integer parentId = entity.getChild().getParent().getId();
		Discountcard card = parentDao.findOne(parentId).getDiscountcards().iterator().next();
		Long deltaPoints = entity.getAmount() / 1000;
		card.addBalance(deltaPoints.intValue());
		discountCardDao.save(card);
		return super.create(entity);
	}

}
