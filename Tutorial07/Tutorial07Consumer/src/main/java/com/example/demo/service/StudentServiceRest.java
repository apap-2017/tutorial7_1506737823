package com.example.demo.service;

import com.example.demo.dao.CourseDAO;
import com.example.demo.model.CourseModel;
import com.example.demo.model.StudentModel;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Primary
public class StudentServiceRest implements StudentService
{
    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public StudentModel selectStudent (String npm)
    {
        log.info ("REST - select student with npm {}", npm);
        return studentDAO.selectStudent (npm);
    }
    @Override
    public List<StudentModel> selectAllStudents ()
    {
        log.info ("REST - select all students");
        return studentDAO.selectAllStudents();
    }
    @Override
    public void addStudent (StudentModel student){}
    @Override
    public void deleteStudent (String npm){}
    @Override
    public void updateStudent(StudentModel student) {}

    @Override
    public CourseModel selectCourse(String id) {
        return courseDAO.selectCourse(id);
    }

    @Override
    public List<CourseModel> selectAllCourse() {
        return courseDAO.selectAllCourses();
    }
}
