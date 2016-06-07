package com.epam.spring.service;

import com.epam.spring.DemoApplication;
import com.epam.spring.entity.Course;
import com.epam.spring.entity.Student;
import com.epam.spring.repository.CourseRepository;
import com.epam.spring.repository.StudentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class CourseServiceTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    public static final String GO = "Go";
    public static final String JAVA = "Java";
    public static final String SCALA = "Scala";
    Course javaCourse, scalaCourse;

    @Before
    public void setup() {
        courseRepository.deleteAll();
        studentRepository.deleteAll();
        javaCourse = new Course(JAVA);
        javaCourse = courseRepository.save(javaCourse);
        scalaCourse = new Course(SCALA);
        scalaCourse = courseRepository.save(scalaCourse);
    }

    @Test
    public void testCreateCourse() throws Exception {
        Course courseGo = courseService.createCourse(GO);
        notNull(courseGo);
        courseGo = courseRepository.findOne(courseGo.getId());
        notNull(courseGo);
        isTrue(courseGo.getName().equals(GO));
    }

    @Test
    public void testGetStudentsByCourseId() throws Exception {
        Course courseJava = courseRepository.findByName(JAVA);
        Student student1 = new Student("john", "coen");
        studentRepository.save(student1);
        courseJava.addStudent(student1);
        Student student2 = new Student("joe", "coen");
        studentRepository.save(student2);
        courseJava.addStudent(student2);
        courseJava = courseRepository.save(courseJava);

        Collection<Student> studentsJava = courseService.getStudentsByCourseId(courseJava.getId());
        isTrue(studentsJava.size() == 2);
        isTrue(studentsJava.contains(student1));
        isTrue(studentsJava.contains(student2));
    }

    @Test
    public void testGetAllCourses() throws Exception {
        Collection<Course> courses = courseService.getAllCourses();
        isTrue(courses.contains(javaCourse));
        isTrue(courses.contains(scalaCourse));
    }
}