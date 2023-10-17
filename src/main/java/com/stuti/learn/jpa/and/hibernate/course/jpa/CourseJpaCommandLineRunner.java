package com.stuti.learn.jpa.and.hibernate.course;

import com.stuti.learn.jpa.and.hibernate.course.Course;
import com.stuti.learn.jpa.and.hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1,"Jpa ","Megha"));
        courseJpaRepository.insert(new Course(2,"H2","Stuti"));
        courseJpaRepository.insert(new Course(3,"Hibernate","Guru"));

        courseJpaRepository.deleteById(1);

        System.out.println(courseJpaRepository.findById(2));
        System.out.println(courseJpaRepository.findById(3));
    }
}
