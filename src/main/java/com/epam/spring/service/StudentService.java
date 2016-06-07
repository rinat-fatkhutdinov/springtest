package com.epam.spring.service;

import com.epam.spring.entity.Student;
import com.epam.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    private Collection<Student> all;

    public Student addStudent(String name, String last) {
        Student student = new Student(name, last);
        return repository.save(student);
    }

    public Collection<Student> getAll() {
        Iterable<Student> iterableCourses = repository.findAll();
        Collection<Student> students = new ArrayList<Student>();
        iterableCourses.forEach(students::add);
        return students;
    }
}
