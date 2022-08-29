package com.myboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboot.entity.StudentEntity;
import com.myboot.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	public List<StudentEntity> getAllStudents(){
		return repo.findAll();
	}
	public void saveStudent(StudentEntity stud) {
		repo.save(stud);
	}
	public StudentEntity findStudentById(int id) {
		Optional<StudentEntity> optional=repo.findById(id);
		StudentEntity student=null;
		if(optional.isPresent()) {
			student=optional.get();
		}
		else {
			throw new RuntimeException("Student not found for id:: "+id);
		}
		return student;
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}
