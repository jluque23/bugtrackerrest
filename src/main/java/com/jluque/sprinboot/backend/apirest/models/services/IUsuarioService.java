package com.jluque.sprinboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jluque.sprinboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Usuario save(Usuario usuario);
	
	public Usuario findByUsername(String username);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
	
	public void insertUsuarioRol(Usuario usuario);
	
	public void insertUsuariosRolAdmin(Usuario usuario);
}
