package com.elcuarzo.mvc.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.elcuarzo.mvc.modelos.Estudiante;
import com.elcuarzo.mvc.servicio.ListaServicios;

@Controller
public class Controlador {
	private final ListaServicios listaServicios;
	
	public Controlador(ListaServicios listaServicios) {
		this.listaServicios = listaServicios;
	}
	
	@RequestMapping("/")
	public String mostrarEstudiantes(Model model) {
		List<Estudiante> estudiante = listaServicios.DesplegarEstudiantes();
		model.addAttribute("estudiante", estudiante);
		return "/mostrar.jsp";
	}
	
	@RequestMapping("/estudiante/nuevo")
	public String estudianteNuevo(@RequestParam("nombre") String nombre,
								  @RequestParam("apellido") String apellido,
								  @RequestParam("edad") Integer edad) {
		Estudiante estudiante = new Estudiante(nombre, apellido, edad);
		listaServicios.CrearEstudiante(estudiante);
		return "/Listo.jsp";
	}
	
	@RequestMapping("/contacto/nuevo")
	public String contactoNuevo(@RequestParam("estudiante") Long estudiante,
								@RequestParam("direccion") String direccion,
								@RequestParam("ciudad") String ciudad,
								@RequestParam("provincia") String provincia) {
			listaServicios.CrearContacto(estudiante, direccion, ciudad, provincia);
			return "/Listo.jsp";
	}
	
	
}
