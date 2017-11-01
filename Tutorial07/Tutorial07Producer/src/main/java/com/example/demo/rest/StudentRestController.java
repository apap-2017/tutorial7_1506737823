package com.example.demo.rest;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentRestController
{
    @Autowired
    StudentService studentService;
    @RequestMapping("/student/view/{npm}")
    public StudentModel view (@PathVariable(value = "npm") String npm) {
        StudentModel student = studentService.selectStudent (npm);
        return student;
    }

    @RequestMapping("/student/viewall")
    public List<StudentModel> view (Model model)
    {
        List<StudentModel> students = studentService.selectAllStudents ();

        return students;
    }
}

