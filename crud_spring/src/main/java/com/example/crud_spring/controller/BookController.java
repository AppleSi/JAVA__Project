package com.example.crud_spring.controller;

import com.example.crud_spring.model.Book;
import com.example.crud_spring.model.Student;
import com.example.crud_spring.service.BookService;
import com.example.crud_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private final BookService bookService;
    private final StudentService studentService;


    public BookController(BookService bookService, StudentService studentService) {
        this.bookService = bookService;
        this.studentService = studentService;
    }

    @GetMapping("/books")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-list";
    }

    @PostMapping("/book-create/{id}")
    public String createBook(@PathVariable("id") Long id, String book_name){
        Book book = new Book(book_name, studentService.findById(id));
        bookService.saveBook(book);
        return "redirect:/books";
    }
}
