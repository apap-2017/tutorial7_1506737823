package com.example.demo.rest;

import com.example.demo.model.CourseModel;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CourseRestController
{
    @Autowired
    StudentService studentService;

    @GetMapping("/course/view/{id}")
    public CourseModel selectCourse(@PathVariable(value = "id") String id){
        CourseModel course = studentService.selectCourse (id);
        return course;
    }

    @GetMapping("/course/viewall")
    public List<CourseModel> selectAllCourse(){
        List<CourseModel> courses = studentService.selectAllCourse();
        return courses;
    }
}