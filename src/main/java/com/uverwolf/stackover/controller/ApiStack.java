package com.uverwolf.stackover.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uverwolf.stackover.models.Question;
import com.uverwolf.stackover.services.StackServices;

@RestController
public class ApiStack {
	public final StackServices servicios;
	public ApiStack(StackServices serv) {
		this.servicios=serv;
	}
	
	@GetMapping("/api/preguntas")
	public List<Question> verPreguntas(){
		return servicios.listarPreguntas();
	}
}
