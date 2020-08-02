package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jluque.sprinboot.backend.apirest.models.dao.IBugDao;
import com.jluque.sprinboot.backend.apirest.models.entity.Bug;

@Service
public class BugServiceImpl implements IBugService {

	@Autowired
	private IBugDao bugDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Bug> findAll() {
		return bugDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Bug> findAll(Pageable pageable) {
		return bugDao.findAll(pageable);
	}

	@Override
	@Transactional
	public Bug findById(Long id) {
		return bugDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Bug save(Bug bug) {
		return bugDao.save(bug);
	}

}
