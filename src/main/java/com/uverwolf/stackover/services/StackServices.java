package com.uverwolf.stackover.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uverwolf.stackover.models.Answer;
import com.uverwolf.stackover.models.Question;
import com.uverwolf.stackover.models.Tag;
import com.uverwolf.stackover.repositories.AnswerRepository;
import com.uverwolf.stackover.repositories.QuestionRepository;
import com.uverwolf.stackover.repositories.TagRepository;

@Service
public class StackServices {
	private final AnswerRepository servAnswer;
	private final QuestionRepository servQuestion;
	private final TagRepository servTag;
	public StackServices( QuestionRepository serv,TagRepository servTag,AnswerRepository servAns) {
		this.servQuestion =serv;
		this.servAnswer=servAns;
		this.servTag=servTag;
	}
	
	public List<Question> listarPreguntas(){
		return servQuestion.findAll();

	}
	public List<Tag> tagListar(){
		return servTag.findAll();
	}
	public Question registrarPregunta(Question pregunta) {
		return servQuestion.save(pregunta);
	}
	public Tag registrarTag(Tag tag) {
		return servTag.save(tag);
	}
	public Answer crearRespuesta(Answer respuesta) {
		return servQuestion.save(respuesta);
	}
	
	//respuestas
	public List<Answer> respuestasPregunta(Long id){
		return servAnswer.findAnswerByQuestion_id(id);
	}
	public Question agregarTags(Long id, Tag tag) {
		
		Optional<Question> pregunta = servQuestion.findById(id);
		if(pregunta.isPresent()) {
			pregunta.get().getTags().add(tag);
			
			return servQuestion.save(pregunta.get());
		}else {
			return null;
		}
	
	}

	public Tag buscarTag(Long idT) {
		Optional<Tag> tag = servTag.findById(idT);
		if(tag.isPresent()) {
			return tag.get();
		}else {
			return null;
		}
	}
	public List<Tag> verTags(Long id){
	return servTag.findByQuestionsId(id);
	}

	public Question buscarPregunta(Long id) {
		Optional<Question> pregunta = servQuestion.findById(id);
		if(pregunta.isPresent()) {
			return pregunta.get();
		}else {
			return null;
		}
	
		
	}
}
