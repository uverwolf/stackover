package com.uverwolf.stackover.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.uverwolf.stackover.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	
	@Query("select tags.subject, questions.question from tags inner join question_tag on tags.id = question_tag.tag_id inner join questions on\r\n" + 
			"questions.id = question_tag.question_id where questions.id = ?1 and question_tag.question_id =?1")
	List<Tag> findByQuestionsId(Long id);
}
