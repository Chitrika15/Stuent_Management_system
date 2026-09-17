package com.example.student.management.system.service;

import com.example.student.management.system.model.Student;
import com.example.student.management.system.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    // GET ALL
    public List<Student> getStudents() {
        return repository.findAll();
    }

    // GET BY ID
    public Student getStudent(int id) {
        return repository.findById(id).orElse(null);
    }

    // POST
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // PUT
    public Student updateStudent(int id, Student student) {

        if (repository.existsById(id)) {

            student.setId(id);

            return repository.save(student);
        }

        return null;
    }

    // DELETE
    public boolean deleteStudent(int id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return true;
        }

        return false;
    }
}