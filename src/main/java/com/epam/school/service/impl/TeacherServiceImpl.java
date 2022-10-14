package com.epam.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.school.entities.Teacher;
import com.epam.school.repository.TeacherRepository;
import com.epam.school.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public void save(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	@Override
	public void edit(Integer id, Teacher teacher) {
		Teacher found = teacherRepository.findById(id).get();
		found.setName(teacher.getName());
		found.setLastName(teacher.getLastName());
		found.setStudents(teacher.getStudents());
		save(teacher);
	}

	@Override
	public void delete(Integer id) {
		teacherRepository.deleteById(id);
	}

	@Override
	public Teacher findById(Integer id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public List<Teacher> findByName(String name) {
		return teacherRepository.findByName(name);
	}

	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public List<Teacher> findByLastName(String lastName) {
		return teacherRepository.findByLastName(lastName);
	}

}
