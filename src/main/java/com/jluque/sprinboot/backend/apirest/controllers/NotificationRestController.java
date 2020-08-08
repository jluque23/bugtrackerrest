package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jluque.sprinboot.backend.apirest.models.entity.Notification;
import com.jluque.sprinboot.backend.apirest.models.services.INotificationService;

//@CrossOrigin(origins = { "http://localhost:4200","http://localhost:5000", "*" })
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class NotificationRestController {

	@Autowired
	private INotificationService notificationService;

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/notifications")
	public List<Notification> index() {
		return notificationService.findAll();
	}

	@PostMapping("/notifications")
	@ResponseStatus(HttpStatus.CREATED)
	public Notification create(@RequestBody Notification notification) {
		return notificationService.save(notification);
	}

}
