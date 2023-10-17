package com.stuti.learn.jpa.and.hibernate.course.springdatajpa;

import com.stuti.learn.jpa.and.hibernate.course.Course;
//import com.stuti.learn.jpa.and.hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseSpringDataJpaRepository.save(new Course(1,"Jpa ","Megha"));
        courseSpringDataJpaRepository.save(new Course(2,"H2","Stuti"));
        courseSpringDataJpaRepository.save(new Course(3,"Hibernate","Guru"));

        courseSpringDataJpaRepository.deleteById(1l);

        System.out.println(courseSpringDataJpaRepository.findById(2l));
        System.out.println(courseSpringDataJpaRepository.findById(3l));

        System.out.println(courseSpringDataJpaRepository.findAll());
        System.out.println(courseSpringDataJpaRepository.count());

        System.out.println(courseSpringDataJpaRepository.findByAuthor("Stuti"));
        System.out.println(courseSpringDataJpaRepository.findByAuthor(""));

        System.out.println(courseSpringDataJpaRepository.findByName("Hibernate"));
        System.out.println(courseSpringDataJpaRepository.findByName("H2"));
    }
}
