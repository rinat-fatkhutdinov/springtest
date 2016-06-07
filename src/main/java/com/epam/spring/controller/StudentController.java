package com.epam.spring.controller;

import com.epam.spring.entity.Student;
import com.epam.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Collection<Student> get() {
        return service.getAll();
    }


}
