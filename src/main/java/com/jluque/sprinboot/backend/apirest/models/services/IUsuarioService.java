package com.jluque.sprinboot.backend.apirest.models.services;

import com.jluque.sprinboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario save(Usuario usuario);
	
	public Usuario findByUsername(String username);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
	
	public void insertUsuarioRol(Usuario usuario);
}
