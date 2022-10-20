package com.epam.school.service;

import java.util.List;

import com.epam.school.dto.StudentUserDTO;
import com.epam.school.entities.Student;

public interface StudentService {

	public void registerStudent(StudentUserDTO dto);
	public void edit(Integer id, StudentUserDTO dto);
	public void delete(Integer id);
	//for testing
	public void save(Student student);
	public Student findById(Integer id);
	public List<Student> findByName(String name);
	public List<Student> findByLastName(String lastName);
	public List<Student> findAll();
	
}
