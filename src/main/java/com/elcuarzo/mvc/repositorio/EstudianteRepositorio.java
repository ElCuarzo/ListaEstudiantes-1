package com.elcuarzo.mvc.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcuarzo.mvc.modelos.Estudiante;

public interface EstudianteRepositorio extends CrudRepository<Estudiante, Long>{
	List<Estudiante> findAll();
}
