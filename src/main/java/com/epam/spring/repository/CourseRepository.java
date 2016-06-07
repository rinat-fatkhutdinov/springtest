package com.epam.spring.repository;

import com.epam.spring.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
