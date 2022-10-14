package com.epam.school.service;

import java.util.List;

import com.epam.school.entities.Student;

public interface StudentService {

	public void save(Student student);
	public void edit(Integer id, Student student);
	public void delete(Integer id);
	public Student findById(Integer id);
	public List<Student> findByName(String name);
	public List<Student> findByLastName(String lastName);
	public List<Student> findAll();
	
}
