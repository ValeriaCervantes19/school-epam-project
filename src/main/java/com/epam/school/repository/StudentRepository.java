package com.epam.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.school.entities.Student;
							
@Repository											//entity and type of the PK
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	//for testing
	//public Student findByName(String name);
	public List<Student> findByName(String name);
	public List<Student> findByLastname(String lastName);
}
