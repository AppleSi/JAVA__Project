package com.example.crud_spring.service;

import com.example.crud_spring.model.Book;
import com.example.crud_spring.model.Student;
import com.example.crud_spring.repository.BookRepo;
import com.example.crud_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final StudentRepository studentRepository;

    @Autowired
    public BookService(BookRepo bookRepo, StudentRepository studentRepository) {
        this.bookRepo = bookRepo;
        this.studentRepository = studentRepository;
    }

    public Book findById(Long id){
        return bookRepo.findById(id).orElse(null);
    }

    public List<Book> findAll(){
        return (List<Book>) bookRepo.findAll();
    }

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteById(Long id){
        bookRepo.deleteById(id);
    }


}
