package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Bug;

public interface IBugService {
	
	public List<Bug> findAll();

	public Page<Bug> findAll(Pageable pageable);

	public Bug findById(Long id);

	public Bug save(Bug bug);
	
}
