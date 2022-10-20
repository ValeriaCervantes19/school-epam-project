package com.epam.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.school.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
	
	public List<Teacher> findByName(String name);
	public List<Teacher> findByLastname(String lastName);
	
}
