package com.github.springbootdocker.service;

import com.github.springbootdocker.dao.StudentDao;
import com.github.springbootdocker.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getStudents() {
        List<Student> students = this.studentDao.getStudent();
        return students;
    }

    public boolean saveStudent(Student student) {
        return this.studentDao.saveStudent(student);
    }
}
