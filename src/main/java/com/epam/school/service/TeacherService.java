package com.epam.school.service;

import java.util.List;

import com.epam.school.entities.Teacher;

public interface TeacherService {

	public void save(Teacher teacher);
	public void edit(Integer id, Teacher teacher);
	public void delete(Integer id);
	public Teacher findById(Integer id);
	public List<Teacher> findByName(String name);
	public List<Teacher> findByLastName(String lastName);
	public List<Teacher> findAll();
	
}
