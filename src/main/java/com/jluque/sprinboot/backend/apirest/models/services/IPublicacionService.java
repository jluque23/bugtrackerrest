package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Publicacion;

public interface IPublicacionService {

	public List<Publicacion> findAll();
	
	public Page<Publicacion> findAll(Pageable pageable);
	
	public Publicacion findById(Long id);
	
	public Publicacion save(Publicacion publicacion);
	
	public void delete(Long id);
}
