package com.epam.school.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.school.dto.StudentUserDTO;
import com.epam.school.entities.EpamUser;
import com.epam.school.entities.Lesson;
import com.epam.school.entities.Student;
import com.epam.school.entities.Teacher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	
	@MockBean
	StudentService studentService;
	
	@BeforeEach
	public void setUp() {
		System.out.println("Hello world!");
	}
	
	@Test
	public void checkIfStudentServiceIsNotNull() {
		assertThat(studentService).isNotNull();
	}
	
	@Test
	public void saveStudentTests() {
		Student student = new Student(new Lesson(), new Teacher(), new EpamUser(), "Valeria", "Cervantes");
		studentService.save(student);
		when(studentService.findById(student.getId())).thenReturn(student);
		Student found = studentService.findById(student.getId());
		
		assertThat(found).isNotNull();
		assertThat(found.getName()).isEqualTo(student.getName());
		assertThat(found.getLastname()).isEqualTo(student.getLastname());
		assertThat(found.getLesson()).isEqualTo(student.getLesson());
	}
	
	@Test
	public void testFindStudent() {
		when(studentService.findById(4)).thenReturn(new Student());
		studentService.findById(4);
		assertNotNull(studentService.findById(4));
	}
	
}
