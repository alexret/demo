package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCalendario {
	
	@RequestMapping(value="/formulario", method=RequestMethod.GET)
	public String get_form() {

		return "formulario";
	}
	
	
	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String post_form(Model modelo,
			@RequestParam String nombre,
			@RequestParam String apellido1,
			@RequestParam String apellido2,
			@RequestParam String email,
			@RequestParam String genero,
			@RequestParam String direccion) {

		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellido1", apellido1);
		modelo.addAttribute("apellido2", apellido2);
		modelo.addAttribute("email", email);
		modelo.addAttribute("genero", genero);
		modelo.addAttribute("direccion", direccion);

		return "mostrarform";
	}

}
