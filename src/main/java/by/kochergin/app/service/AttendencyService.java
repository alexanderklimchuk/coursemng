package by.kochergin.app.service;

import by.kochergin.app.dao.IAttendencyDao;
import by.kochergin.app.domain.Attendency;

public class AttendencyService extends GenericService<Attendency, Integer, IAttendencyDao> {
	@Override
	public Attendency create(Attendency entity) {
		return super.create(entity);
	}
}
