package com.uverwolf.stackover.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uverwolf.stackover.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer>findAnswerByQuestion_id(Long id);
}
