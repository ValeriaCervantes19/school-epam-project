package com.epam.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.school.entities.Student;
							
												//entity and type of the PK
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
	public List<Student> findByLastname(String lastName);
}
