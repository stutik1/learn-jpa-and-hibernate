package com.stuti.learn.jpa.and.hibernate.course.jdbc;

import com.stuti.learn.jpa.and.hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate ;

    public static String INSERT_QUERY =
        """
            insert into course(id,name,author)
            values(?,?,?);
            //values(1,'Jpa','Megha'),(2,'H2','Stuti')
        """;

    public static String DELETE_QUERY =
            """
                delete from course
                where id = ? ;
            """;

    public static String SELECT_QUERY =
            """
                select * from course
                where id = ? ;
            """;

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course getById(long id){
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
