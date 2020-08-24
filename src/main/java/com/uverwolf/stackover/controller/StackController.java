package com.uverwolf.stackover.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uverwolf.stackover.models.Answer;
import com.uverwolf.stackover.models.Question;
import com.uverwolf.stackover.models.Tag;
import com.uverwolf.stackover.models.registerQT;
import com.uverwolf.stackover.services.StackServices;

@Controller
public class StackController {
	private final StackServices servicios;
	public StackController(StackServices serv) {
		this.servicios=serv;
	}
	@GetMapping("questions")
	public String index(Model modelo) {
		modelo.addAttribute("preguntas", servicios.listarPreguntas());
		return "vistas/index.jsp";
	}
	
	
	@GetMapping("questions/ver/{id}")
	public String verPregunta(@ModelAttribute("respuesta")Answer resp, @PathVariable("id")Long id,Model modelo) {
		Question preg =	servicios.buscarPregunta(id);
		
		modelo.addAttribute("respuestas", servicios.respuestasPregunta(id));
		modelo.addAttribute("pregunta", preg);
		return "vistas/verPregunta.jsp";
	}
	
	@PostMapping("questions/ver/{id}")
	public String agregarRespuesta(@ModelAttribute("respuesta")Answer resp, @PathVariable("id") Long id) {
		servicios.crearRespuesta(resp);
		return "redirect:/questions/ver/"+id;
	}
	
	
	//----------------------------------------
	@GetMapping("questions/new")
	public String nuevaPregunta(@ModelAttribute("preguntaV")registerQT test) {
		return "vistas/pregunta.jsp";
	}
	@PostMapping("questions/new")
	public String agregarPregunta(@ModelAttribute("preguntaV") registerQT test,Model modelo) {
		Question preg = new Question();
		Tag tag = new Tag();
		
		preg.setQuestion(test.getPregunta());
		tag.setSubject(test.getTags());
		
		servicios.registrarPregunta(preg);
		servicios.registrarTag(tag);
		
		modelo.addAttribute("pregunta", preg);
		modelo.addAttribute("tag",tag);
		return "redirect:/questions/"+preg.getId()+"-"+tag.getId();
	}
	@GetMapping("questions/{id}-{tag}")
	public String exito(@PathVariable("id")Long id,@PathVariable("tag")Long idT) {
		
		servicios.agregarTags(id, servicios.buscarTag(idT));
		
		return "redirect:/questions";
	}
		
		
	}

