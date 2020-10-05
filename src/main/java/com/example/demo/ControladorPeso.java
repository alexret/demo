package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorPeso {
	
	@RequestMapping(value="/imc", method=RequestMethod.GET)
	public String get_form() {

		return "imc";
	}
	
	
	@RequestMapping(value="/imc", method=RequestMethod.POST)
	@ResponseBody
	public  String post_form(Model modelo,
			@RequestParam Double peso,
			@RequestParam Double altura,
			@RequestParam Double edad,
			@RequestParam String hm) {

			modelo.addAttribute("peso", peso);
			modelo.addAttribute("altura", altura);
			modelo.addAttribute("edad", edad);
			modelo.addAttribute("hm", hm);
			
			String resultado = "";
			modelo.addAttribute("resultado", resultado);
			
			Double imc;
			Double grasa;
			Double sexo = (double) 0;
			
			if (hm == "m")
				sexo = (double) 1;
			
			imc = peso / (altura * altura);
			
			grasa = (1.2 * imc) + (0.23 * edad) - (10.8 * sexo) - 5.4;
			
			
				
			if(sexo == 1) {
				resultado = calculo_h(grasa);
			} else if  (sexo == 0)
				resultado = calculo_m(grasa);
	
		return resultado;
	}
	
	private String calculo_m(Double grasa) {
		String aux = "";
		if(grasa >= 10 && grasa <= 13)
			aux = "Grasa esencial";
		else if (grasa >= 14 && grasa <= 20)
			aux = "Atletas";
		else if (grasa >=21 && grasa <= 24)
			aux = "Fitness";
		else if (grasa >= 25 && grasa <= 31)
			aux = "Aceptable";
		else if (grasa >=31)
			aux = "Obesidad";
		return aux;
	}
	
	private String calculo_h(Double grasa) {
		String aux = "";
		if(grasa >= 2 && grasa <= 5)
			aux = "Grasa esencial";
		else if (grasa >= 6 && grasa <= 13)
			aux = "Atletas";
		else if (grasa >= 14 && grasa <= 17)
			aux = "Fitness";
		else if (grasa >= 18 && grasa <= 24)
			aux = "Aceptable";
		else if (grasa >= 25)
			aux = "Obesidad";
		return aux;
	}

}
