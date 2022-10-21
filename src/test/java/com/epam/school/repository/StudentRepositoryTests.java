package com.epam.school.repository;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.school.entities.EpamUser;
import com.epam.school.entities.Lesson;
import com.epam.school.entities.Student;
import com.epam.school.entities.Teacher;

import static org.assertj.core.api.Assertions.assertThat;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;

@RunWith(SpringRunner.class)
//@DataJpaTest
//@ActiveProfiles("test")
//@TestPropertySource("classpath:application.properties")
//@TestPropertySource(locations = "classpath:application-test.properties")
//@SpringBootTest
public class StudentRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void checkIfStudentRepositoryIsNotNull() {
		assertThat(studentRepository).isNotNull();
	}
	
	EpamUser user = new EpamUser("username", "email@gmail.com", "password", "ROLE_STUDENT");
	Lesson lesson = new Lesson("title", 99.0f);
	Teacher teacher = new Teacher(user, "teacherName", "TeacherLastName");
	
	
	@Test
	public void saveStudent() {
		//Properties p = new Properties();
//		try {
//			p.load(new FileInputStream( new File("application.properties")));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Student testStudent = new Student(lesson, teacher, user, "Valeria", "Cervantes");
		entityManager.persistAndFlush(testStudent);
		
		assertThat(testStudent.getId()).isNotNull();
	}

}
