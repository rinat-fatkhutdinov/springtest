package com.epam.spring.service;

import com.epam.spring.entity.Course;
import com.epam.spring.entity.Student;
import com.epam.spring.repository.CourseRepository;
import com.epam.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private CourseRepository courseRepository;

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

    public Student assignCourseToStudent(Long courseId, Long studentId) {
        Course course = courseRepository.findOne(courseId);
        Student student = repository.findOne(studentId);
        course.addStudent(student);
        courseRepository.save(course);
        return student;
    }
}
