package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CourseModel;
import com.example.demo.model.StudentModel;

public interface StudentService
{
    StudentModel selectStudent (String npm);

    List<StudentModel> selectAllStudents ();

    void addStudent (StudentModel student);

    void deleteStudent (String npm);

    void updateStudent (StudentModel student);

    CourseModel selectCourse(String id);
}
