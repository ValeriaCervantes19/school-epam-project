package com.epam.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.school.entities.Student;
import com.epam.school.repository.StudentRepository;
import com.epam.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void edit(Integer id, Student student) {
		Student found = studentRepository.findById(id).get();
		found.setTeacher(student.getTeacher());
		found.setName(student.getName());
		found.setLastname(student.getLastname());
		save(student);
	}

	@Override
	public void delete(Integer id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student findById(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		return studentRepository.findByLastname(lastName);
	}

}
