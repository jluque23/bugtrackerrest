package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.Publicacion;

public interface IPublicacionDao extends JpaRepository<Publicacion, Long>{

}
