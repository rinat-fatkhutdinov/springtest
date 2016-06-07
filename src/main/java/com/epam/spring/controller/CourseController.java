package com.epam.spring.controller;

import com.epam.spring.entity.Course;
import com.epam.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public Course create(@RequestBody String name) {
        return courseService.createCourse(name);
    }

    @RequestMapping
    public Collection<Course> get() {
        return courseService.getAllCourses();
    }
}
