package com.elcuarzo.mvc.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elcuarzo.mvc.modelos.Contacto;
import com.elcuarzo.mvc.modelos.Estudiante;
import com.elcuarzo.mvc.repositorio.ContactoRepositorio;
import com.elcuarzo.mvc.repositorio.EstudianteRepositorio;

@Service
public class ListaServicios {
	private final ContactoRepositorio contactoRepositorio;
	private final EstudianteRepositorio estudianteRepositorio;
	
	//Se inicia el contructor
	public ListaServicios(ContactoRepositorio contactoRepositorio,
						  EstudianteRepositorio estudianteRepositorio) {
		this.contactoRepositorio = contactoRepositorio;
		this.estudianteRepositorio = estudianteRepositorio;
	}
	
	//Desplegar todos los Estudiantes
	public List<Estudiante> DesplegarEstudiantes() {
		return estudianteRepositorio.findAll();
	}
	
	//Desplegar los datos de contacto
	public List<Contacto> DesplegarContacto(){
		return contactoRepositorio.findAll();
	}
	
	//Crear Estudiante
	public Estudiante CrearEstudiante(Estudiante e) {
		return estudianteRepositorio.save(e);
	}
	
	//Obtener estudiante por id
	public Estudiante getEstudianteById(Long estudianteId) {
		return estudianteRepositorio.findById(estudianteId).orElse(null);
	}
	
	//Crear Contacto
	public String CrearContacto(Long personaId, String direccion, String ciudad, String provincia) {
		Optional<Estudiante> estudianteOpcion = estudianteRepositorio.findById(personaId);
		if(estudianteOpcion.isPresent()) {
			Estudiante estudiante = estudianteOpcion.get();
			Contacto contacto = new Contacto();
			contacto.setEstudiante(estudiante);
			contacto.setCiudad(ciudad);
			contacto.setDireccion(direccion);
			contacto.setProvincia(provincia);
			contactoRepositorio.save(contacto);
			return "redirect:/Listo.jsp";
		}
		else {
			return "redirect:/error.jsp";
		}
	}
}
