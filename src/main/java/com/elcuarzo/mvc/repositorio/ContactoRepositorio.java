package com.elcuarzo.mvc.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelos.Contacto;

public interface ContactoRepositorio extends CrudRepository<Contacto, Long> {
	List<Contacto> findAll();
}
