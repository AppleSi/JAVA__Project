package com.example.crud_spring.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stud_id;
    @Column(name = "stud_name")
    private String stud_name;
    @Column(name = "stud_surname")
    private String stud_surname;
    @Column(name = "stud_age")
    private int stud_age;
    @Column(name = "stud_gender")
    private String stud_gender;
    @Column(name = "university")
    private String university;
    @Column(name = "stud_gpa")
    private float stud_gpa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Book> books;

    public void addBook(Book book) {
        books.add(book);
        book.setStudent(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setStudent(null);
    }

}
