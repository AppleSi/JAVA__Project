package com.example.crud_spring.controller;

import com.example.crud_spring.model.Book;
import com.example.crud_spring.model.Student;
import com.example.crud_spring.service.BookService;
import com.example.crud_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final BookService bookService;

    @Autowired
    public StudentController(StudentService studentService, BookService bookService) {
        this.studentService = studentService;
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/students")
    public String findAll(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/student-create")
    public String createStudentForm(Student student){
        return "student-create";
    }

    @PostMapping("/student-create")
    public String createStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/show")
    public String showStudent(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", studentService.findById(id));

        return "student-show";
    }

    @PostMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/edit")
    public String updateStudentForm(@PathVariable("id") Long id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student-update";
    }

    @PostMapping("/student-update")
    public String updateStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
