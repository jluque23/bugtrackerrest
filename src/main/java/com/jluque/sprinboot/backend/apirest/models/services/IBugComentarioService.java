package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import com.jluque.sprinboot.backend.apirest.models.entity.BugComentario;

public interface IBugComentarioService {

//	public List<BugComentario> findAll();
	
	public List<BugComentario> findByBugId(Long bugId);
	
	public BugComentario save(BugComentario bugComentario);
	
//	public void delete(Long id);
}
