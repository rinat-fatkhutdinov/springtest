package com.epam.spring.controller;

import com.epam.spring.entity.Student;
import com.epam.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping(method = RequestMethod.POST)
    public Student create(@RequestBody String name, @RequestBody String last) {
        return service.addStudent(name, last);
    }

    @RequestMapping
    public Collection<Student> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/{id}/{course_id}", method = RequestMethod.PUT)
    public Student assignCourse(@PathVariable("id") Long StudentId, @PathVariable("course_id") Long courseId) {
        Student student = service.assignCourseToStudent(courseId, StudentId);
        return student;
    }

}
