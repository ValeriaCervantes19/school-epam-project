package com.epam.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.school.entities.Student;
import com.epam.school.entities.Teacher;
import com.epam.school.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getTeachers(Model model, @ModelAttribute("newTeacher") Teacher newTeacher,
			@ModelAttribute("updateTeacher") Teacher updateTeacher,
			@ModelAttribute("deleteTeacher") Teacher deleteTeacher,
			@ModelAttribute("idInfo") Teacher infoTeacher,
			@ModelAttribute("findTeacher")Teacher findTeacher){
		List<Teacher> teachers = teacherService.findAll(); 
		model.addAttribute("teachers", teachers);
		return "teachers.html";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String newTeacher(@ModelAttribute("newTeacher") Teacher teacher) {
		teacherService.save(teacher);
		return "redirect:/teacher/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateTeacher(@ModelAttribute("updateTeacher") Teacher updateTeacher) {
		if(teacherService.findById(updateTeacher.getId()) != null) {
			teacherService.edit(updateTeacher.getId(), updateTeacher);
		}
		else {
			System.out.println("Doesn't exist");
		}
		return "redirect:/teacher/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteTeacher(@ModelAttribute("idTeacher") Teacher deleteTeacher) {
		if(teacherService.findById(deleteTeacher.getId()) != null) {
			teacherService.delete(deleteTeacher.getId());
		}
		else {
			System.out.println("Doesn't exist");
		}
		return "redirect:/teacher/list";
	}
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public String showStudents(Model model, @ModelAttribute("idInfo") Teacher infoTeacher) {
		Set<Student> students = infoTeacher.getStudents();
		if(students.size() > 0) {
			model.addAttribute("students", students);
		}
		model.addAttribute("teacher", infoTeacher);
		return "teachersStudents.html";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public String findTeacher(Model model, @ModelAttribute("findTeacher")Teacher findTeacher,
			@ModelAttribute("newTeacher") Teacher newTeacher,
			@ModelAttribute("updateTeacher") Teacher updateTeacher,
			@ModelAttribute("deleteTeacher") Teacher deleteTeacher,
			@ModelAttribute("id") Teacher infoTeacher) {
		List<Teacher> teachers = new ArrayList<>();
		Teacher teacherFound = new Teacher();
		
		if(findTeacher.getId() != null) {	
			teacherFound = teacherService.findById(findTeacher.getId());
			if(teacherFound!=null) {
				teachers.add(teacherFound);
				model.addAttribute("teachers", teachers);
				return "teachers.html";
			}
		}
		
		if(findTeacher.getName()!=null && !findTeacher.getName().isBlank()) {
			teachers = teacherService.findByName(findTeacher.getName());
			if(teachers != null) {
				model.addAttribute("teachers", teachers);
				return "teachers.html";
			}
		}
		
		if(findTeacher.getLastName()!=null && !findTeacher.getLastName().isBlank()) {
			teachers = teacherService.findByLastName(findTeacher.getLastName());
			if(teachers != null) {
				model.addAttribute("teachers", teachers);
				return "teachers.html";
			}
		}	
		
		return "redirect:/teacher/list";
	}
	
}
