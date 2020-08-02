package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import com.jluque.sprinboot.backend.apirest.models.entity.Notification;

public interface INotificationService {

	public List<Notification> findAll();

	public Notification save(Notification notification);
}
