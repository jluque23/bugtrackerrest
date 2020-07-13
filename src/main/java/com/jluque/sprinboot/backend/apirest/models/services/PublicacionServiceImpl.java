package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jluque.sprinboot.backend.apirest.models.dao.IPublicacionDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Publicacion;

@Service
public class PublicacionServiceImpl implements IPublicacionService {

	@Autowired
	private IPublicacionDao publicacionDao; 
	
	@Override
	@Transactional(readOnly = true)
	public List<Publicacion> findAll() {
		return (List<Publicacion>) publicacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Publicacion> findAll(Pageable pageable) {
		return publicacionDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Publicacion findById(Long id) {
		return publicacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Publicacion save(Publicacion publicacion) {
		return publicacionDao.save(publicacion);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		publicacionDao.deleteById(id);
	}

}
