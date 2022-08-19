package com.github.springbootdocker.dao;

import com.github.springbootdocker.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> getStudent() {
        List<Student> students = jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                String studentNumber = resultSet.getString("student_number");
                String studentName = resultSet.getString("student_name");
                String studentAge = resultSet.getString("student_age");

                Student student = new Student();
                student.setStudentNumber(studentNumber);
                student.setStudentName(studentName);
                student.setAge(studentAge);
                return student;
            }
        });

        return students;
    }

    public boolean saveStudent(Student student) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into student (student_number,student_name,student_age) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getStudentNumber());
                ps.setString(2, student.getStudentName());
                ps.setString(3, student.getAge());
                return ps;
            }
        }, keyHolder);
        return true;
    }
}
