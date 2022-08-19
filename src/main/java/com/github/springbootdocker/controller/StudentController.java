package com.github.springbootdocker.controller;

import com.github.springbootdocker.model.Student;
import com.github.springbootdocker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        List<Student> students = this.studentService.getStudents();
        return students;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public boolean saveStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }
}
