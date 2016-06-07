package com.epam.spring.service;

import com.epam.spring.entity.Course;
import com.epam.spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(String name) {
        Course newCourse = new Course(name);
        Course savedCourse = courseRepository.save(newCourse);
        return savedCourse;
    }

    public Collection<Course> getAllCourses() {
        Iterable<Course> iterableCourses = courseRepository.findAll();
        Collection<Course> courses = new ArrayList<Course>();
        iterableCourses.forEach(courses::add);
        return courses;
    }
}
