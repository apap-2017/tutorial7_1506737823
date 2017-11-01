package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;

import javax.validation.Valid;

@Controller
public class StudentController
{
    @Autowired
    StudentService studentDAO;


    @RequestMapping("/")
    public String index ()
    {
        return "index";
    }


    @RequestMapping("/student/add")
    public String add (Model model)
    {
        model.addAttribute("student", new StudentModel());
        return "form-add";
    }


    @RequestMapping("/student/add/submit")
    public String addSubmit (Model model, @Valid @ModelAttribute StudentModel student, BindingResult result)
    {
        if(result.hasErrors()){
            model.addAttribute("student", new StudentModel());
            return "form-add";
        } else if( student.getNpm() == ""){
            model.addAttribute("student", new StudentModel());
            return "form-add";
        } else if(student.getName() == ""){
            model.addAttribute("student", new StudentModel());
            return "form-add";
        }

        studentDAO.addStudent (student);

        return "success-add";
    }


    @RequestMapping("/student/view")
    public String view (Model model,
            @RequestParam(value = "npm", required = false) String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/view/{npm}")
    public String viewPath (Model model,
            @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent (npm);

        if (student != null) {
            model.addAttribute ("student", student);
            return "view";
        } else {
            model.addAttribute ("npm", npm);
            return "not-found";
        }
    }


    @RequestMapping("/student/viewall")
    public String view (Model model)
    {
        List<StudentModel> students = studentDAO.selectAllStudents ();
        model.addAttribute ("students", students);

        return "viewall";
    }


    @RequestMapping("/student/delete/{npm}")
    public String delete (Model model, @PathVariable(value = "npm") String npm)
    {
        if(studentDAO.selectStudent(npm) == null){

            model.addAttribute ("npm", npm);
            return "not-found";
        }
        studentDAO.deleteStudent (npm);

        return "delete";
    }

    @RequestMapping("/student/update/{npm}")
    public String update (Model model, @PathVariable(value = "npm") String npm)
    {
        StudentModel student = studentDAO.selectStudent(npm);
        if(student != null){
            model.addAttribute("name", student.getName());
            model.addAttribute("gpa", student.getGpa());
            model.addAttribute("npm", student.getNpm());
            model.addAttribute("student", student);

            return "form-update";
        }

        model.addAttribute ("npm", npm);
        return "not-found";
    }


    @RequestMapping("/student/update/submit")
    public String updateSubmit (Model model, @Valid @ModelAttribute StudentModel student, BindingResult result)
    {
        if(result.hasErrors()){
            model.addAttribute("name", student.getName());
            model.addAttribute("gpa", student.getGpa());
            model.addAttribute("npm", student.getNpm());
            model.addAttribute("student", student);

            return "form-update";
        } else if( student.getNpm() == ""){
            model.addAttribute("name", student.getName());
            model.addAttribute("gpa", student.getGpa());
            model.addAttribute("npm", student.getNpm());
            model.addAttribute("student", student);

            return "form-update";
        } else if(student.getName() == ""){
            model.addAttribute("name", student.getName());
            model.addAttribute("gpa", student.getGpa());
            model.addAttribute("npm", student.getNpm());
            model.addAttribute("student", student);

            return "form-update";
        }

        studentDAO.updateStudent (student);

        return "success-update";
    }

    @GetMapping("/course/view/{id}")
    public String selectCourse(@PathVariable(value = "id") String id, Model model){
        CourseModel course = studentDAO.selectCourse (id);

        if (course != null) {
            model.addAttribute ("course", course);
            return "view-course";
        } else {
            model.addAttribute ("npm", id);
            return "course-not-found";
        }
    }
}
