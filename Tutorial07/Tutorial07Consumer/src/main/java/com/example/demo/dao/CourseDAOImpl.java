package com.example.demo.dao;

import com.example.demo.model.CourseModel;
import com.example.demo.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CourseModel selectCourse(String id) {
        CourseModel course =
                restTemplate.getForObject(
                        "http://localhost:8080/rest/course/view/" + id,
                        CourseModel.class);
        return course;
    }

    @Override
    public List<CourseModel> selectAllCourses() {
        ResponseEntity<List<CourseModel>> response =
                restTemplate.exchange("http://localhost:8080/rest/course/viewall",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseModel>>() {
                        });
        List<CourseModel> courses = response.getBody();
        System.out.println(courses.toString());
        return courses;
    }
}
