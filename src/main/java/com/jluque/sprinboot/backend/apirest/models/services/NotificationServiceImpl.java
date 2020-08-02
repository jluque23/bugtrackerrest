package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jluque.sprinboot.backend.apirest.models.dao.INotificationDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Notification;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	private INotificationDao notificationDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Notification> findAll() {
		return notificationDao.findAll();
	}

	@Override
	@Transactional()
	public Notification save(Notification notification) {
		return notificationDao.save(notification);
	}

}
