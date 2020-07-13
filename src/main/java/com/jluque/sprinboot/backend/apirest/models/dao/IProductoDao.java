package com.jluque.sprinboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>{

	public List<Producto> findByNombreContainingIgnoreCase(String term);
}
