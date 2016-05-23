package by.kochergin.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kochergin.app.dao.IClientstatusDao;
import by.kochergin.app.dao.IParentDao;
import by.kochergin.app.domain.*;
import by.kochergin.app.util.CardUtil;

@Service
public class ParentService extends GenericService<Parent, Integer, IParentDao> {
	@Autowired
	private IParentDao dao;

	@Autowired
	private IClientstatusDao clientStatusDao;

	@PostConstruct
	public void setDao() {
		setDao(dao);
	}

	@Override
	public Parent create(Parent parent) {
		parent.setClientstatus(clientStatusDao.findOne(parent.getClientstatus().getId()));

		Discountcard discountCard = new Discountcard();
		discountCard.setBalance(0);
		discountCard.setNumber(CardUtil.generateCardNumber());
		discountCard.setParent(parent);
		parent.getDiscountcards().add(discountCard);
		return super.create(parent);
	}

	public List<Child> getChildren(Integer id) {
		return new ArrayList<Child>(dao.findOne(id).getChilds());
	}
}
