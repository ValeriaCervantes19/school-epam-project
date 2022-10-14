package com.epam.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.school.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>{
	
	public List<Lesson> findByTitle(String title);
	public List<Lesson> findByGrade(Float grade);
}
