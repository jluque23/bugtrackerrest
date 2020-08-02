package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jluque.sprinboot.backend.apirest.models.entity.BugComentario;
import com.jluque.sprinboot.backend.apirest.models.services.IBugComentarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class BugComentarioRestController {

	@Autowired
	private IBugComentarioService comentarioBugService;

//	@Secured({"ROLE_ADMIN"})
	@PostMapping("/comentariosbug")
	@ResponseStatus(HttpStatus.CREATED)
	public BugComentario crear(@RequestBody BugComentario bugComentario) {
		return comentarioBugService.save(bugComentario);
	}
	
	@GetMapping("/comentariosbug/{bugId}")
	public List<BugComentario> index(@PathVariable Long bugId) {
		return comentarioBugService.findByBugId(bugId);
	}

}
