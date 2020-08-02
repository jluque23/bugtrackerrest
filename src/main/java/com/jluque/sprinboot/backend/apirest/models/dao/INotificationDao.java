package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.Notification;

public interface INotificationDao extends JpaRepository<Notification, Long> {

}
