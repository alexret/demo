package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorHola {
	
  @RequestMapping("/prueba")
  public String hola(Model modelo) {
    
    
    modelo.addAttribute("mensaje","hola desde esta prueba");
    return "hola";
  }
}