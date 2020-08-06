package com.jluque.sprinboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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

//@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5000", "*" })
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class BugComentarioRestController {

	@Autowired
	private IBugComentarioService comentarioBugService;

	@Secured({ "ROLE_USER" })
	@PostMapping("/comentariosbug")
	@ResponseStatus(HttpStatus.CREATED)
	public BugComentario crear(@RequestBody BugComentario bugComentario) {
		return comentarioBugService.save(bugComentario);
	}

	@Secured({ "ROLE_USER" })
	@GetMapping("/comentariosbug/{bugId}")
	public List<BugComentario> index(@PathVariable Long bugId) {
		return comentarioBugService.findByBugId(bugId);
	}

}
