package com.jluque.sprinboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jluque.sprinboot.backend.apirest.models.entity.BugComentario;

public interface IBugComentarioDao extends JpaRepository<BugComentario, Long> {
	
	@Query( value = "SELECT * FROM bug_comentarios u WHERE u.bug_id = ?1", nativeQuery = true)
	List<BugComentario> findByBugId(Long bugId);
}
