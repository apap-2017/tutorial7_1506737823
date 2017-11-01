package com.example.demo.dao;

import com.example.demo.model.StudentModel;

import java.util.List;

public interface StudentDAO
{
    StudentModel selectStudent (String npm);
    List<StudentModel> selectAllStudents ();
}

