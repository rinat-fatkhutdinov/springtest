package com.epam.spring.repository;

import com.epam.spring.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<Student, Long> {
}
