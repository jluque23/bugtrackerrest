package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jluque.sprinboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);

	@Modifying()
	@Query(value = "insert into usuarios_roles (usuario_id,role_id) values (:usuarioId,1)",nativeQuery = true)
	public void insertUsuariosRol(Long usuarioId);

	@Modifying()
	@Query(value = "insert into usuarios_roles (usuario_id,role_id) values (:usuarioId,2)",nativeQuery = true)
	public void insertUsuariosRolAdmin(Long usuarioId);
}
