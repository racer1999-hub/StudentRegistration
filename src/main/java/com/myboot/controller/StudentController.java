package com.myboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myboot.entity.StudentEntity;
import com.myboot.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listOfStudent", service.getAllStudents());
		/*List<StudentEntity> listOfStudents=service.getAllStudents();
		model.addAttribute("listOfStudents", listOfStudents);*/
		return "index";
	}
	@GetMapping("/new")
	public String addStudent(Model model) {
		model.addAttribute("student", new StudentEntity());
		return "new";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") StudentEntity student) {
		service.saveStudent(student);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public ModelAndView showFormForUpdate(@PathVariable(value="id") int id) {
		ModelAndView mv=new ModelAndView("update");
		StudentEntity student=service.findStudentById(id);
		mv.addObject("student", student);
		return mv;
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value="id") int id) {
		service.delete(id);
		return "redirect:/";
		
	}
	
}
