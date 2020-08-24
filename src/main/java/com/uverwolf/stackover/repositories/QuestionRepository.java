package com.uverwolf.stackover.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.uverwolf.stackover.models.Answer;
import com.uverwolf.stackover.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();
	Optional<Question> findById(Long id);
	Answer save(Answer respuesta);

}
