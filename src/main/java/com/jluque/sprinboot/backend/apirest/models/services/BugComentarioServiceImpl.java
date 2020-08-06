package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jluque.sprinboot.backend.apirest.models.dao.IBugComentarioDao;
import com.jluque.sprinboot.backend.apirest.models.entity.BugComentario;

@Service
public class BugComentarioServiceImpl implements IBugComentarioService {

	@Autowired
	private IBugComentarioDao bugComentarioDao;

	@Override
	@Transactional
	public BugComentario save(BugComentario bugComentario) {
		return bugComentarioDao.save(bugComentario);
	}

	@Override
	public List<BugComentario> findByBugId(Long bugId) {
		return bugComentarioDao.findByBugId(bugId);
	}

}
