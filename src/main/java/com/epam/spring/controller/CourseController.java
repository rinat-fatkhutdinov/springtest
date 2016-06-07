package com.epam.spring.controller;

import com.epam.spring.entity.Course;
import com.epam.spring.entity.Student;
import com.epam.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}")
    public Collection<Student> getStudents(@PathVariable("id") Long courseId) {
        return courseService.getStudentsByCourseId(courseId);
    }

    @RequestMapping
    public Collection<Course> get() {
        return courseService.getAllCourses();
    }

}
