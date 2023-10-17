package com.stuti.learn.jpa.and.hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public static String INSERT_QUERY =
        """
            insert into course(id,name,author)
            values(1,'Jpa','Megha'),(2,'H2','Stuti');
        """;

    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }
}
