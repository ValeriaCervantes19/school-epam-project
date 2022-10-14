package com.epam.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.school.entities.Student;
import com.epam.school.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getStudents(Model model, 
			@ModelAttribute("newStudent") Student newStudent,
			@ModelAttribute("updateStudent") Student updateStudent,
			@ModelAttribute("deleteStudent")Student deleteStudent,
			@ModelAttribute("findStudent") Student findStudent){
		List<Student> students = studentService.findAll(); 
		model.addAttribute("students", students);
		return "students.html";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String newStudent(@ModelAttribute("newStudent") Student newStudent) {
		studentService.save(newStudent);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateStudent(@ModelAttribute("updateStudent") Student updateStudent) {
		if(studentService.findById(updateStudent.getId()) != null) {
			studentService.edit(updateStudent.getId(), updateStudent);
		}
		else {
			System.out.println("Doesn't exist");
		}
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteStudent(@ModelAttribute("idStudent") Student deleteStudent) {
		if(studentService.findById(deleteStudent.getId()) != null) {
			studentService.delete(deleteStudent.getId());
		}
		else {
			System.out.println("Doesn't exist");
		}
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public String findStudent(Model model, 
			@ModelAttribute("findStudent") Student findStudent,
			@ModelAttribute("newStudent") Student newStudent,
			@ModelAttribute("updateStudent") Student updateStudent,
			@ModelAttribute("deleteStudent")Student deleteStudent) {
		List<Student> students = new ArrayList<>();
		Student studentFound = new Student();
		
		if(findStudent.getId() != null) {	
			studentFound = studentService.findById(findStudent.getId());
			if(studentFound!=null) {
				students.add(studentFound);
				model.addAttribute("students", students);
				return "students.html";
			}
		}
		
		if(findStudent.getName()!=null && !findStudent.getName().isBlank()) {
			students = studentService.findByName(findStudent.getName());
			if(students != null) {
				model.addAttribute("students", students);
				return "students.html";
			}
		}
		
		if(findStudent.getLastname()!=null && !findStudent.getLastname().isBlank()) {
			students = studentService.findByLastName(findStudent.getLastname());
			if(students != null) {
				model.addAttribute("students", students);
				return "students.html";
			}
		}	
		
		return "redirect:/student/list";
	}
}
