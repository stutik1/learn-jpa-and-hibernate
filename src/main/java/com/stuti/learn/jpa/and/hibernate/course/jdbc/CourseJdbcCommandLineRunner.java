package com.stuti.learn.jpa.and.hibernate.course.jdbc;

import com.stuti.learn.jpa.and.hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;
    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1,"Jpa and H2","Megha"));
        courseJdbcRepository.insert(new Course(2,"Jpa","Stuti"));
        courseJdbcRepository.insert(new Course(3,"Hibernate","Guru"));

        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.getById(2));
        System.out.println(courseJdbcRepository.getById(3));
    }
}
