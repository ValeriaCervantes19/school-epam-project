package com.epam.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.school.entities.Lesson;
import com.epam.school.repository.LessonRepository;
import com.epam.school.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService{
	
	@Autowired
	LessonRepository lessonRepository;

	@Override
	public void save(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	@Override
	public void edit(Integer id, Lesson lesson) {
		Lesson found = lessonRepository.findById(id).get();
		found.setTitle(lesson.getTitle());
		found.setGrade(lesson.getGrade());
		save(lesson);
	}

	@Override
	public void delete(Integer id) {
		lessonRepository.deleteById(id);
	}

	@Override
	public Lesson findById(Integer id) {
		return lessonRepository.findById(id).get();
	}

	@Override
	public List<Lesson> findByTitle(String title) {
		return lessonRepository.findByTitle(title);
	}

	@Override
	public List<Lesson> findAll() {
		return lessonRepository.findAll();
	}

	@Override
	public List<Lesson> findByGrade(Float grade) {
		return lessonRepository.findByGrade(grade);
	}

}
