package com.epam.school.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.school.entities.Lesson;


@SpringBootTest
@DataJpaTest  //just for components of the persistence layer 
@RunWith(SpringRunner.class)
public class LessonRepositoryTests {
	
	@Autowired
	LessonRepository lessonRepository;
	
	//to execute before others
	@BeforeEach
	public void setUp() {
		Lesson lesson = new Lesson();	
	}
	
	@Test
	public void checkIfLessonRepositoryIsNotNull() {
		Lesson lesson = new Lesson();
		lessonRepository.save(lesson);
		assertThat(lessonRepository).isNotNull();
	}
	
//	@Test
//	public void testSaveLesson() {
//		//given - precondition or configuration
//		Lesson lesson1 = new Lesson("lasson1", 90.3f, null);
//					
//		//when - action or behavior that we are gonna test
//		Lesson storedLesson = lessonRepository.save(lesson1);
//		
//		//then - verify data output
//		assertThat(storedLesson).isNotNull();
//		assertThat(storedLesson.getId()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void testListLessons() {
//		Lesson lesson2 = new Lesson("lasson1", 90.3f, null);
//	}
//	
}

