 package com.jluque.sprinboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.jluque.sprinboot.backend.apirest.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura,Long>{

}
