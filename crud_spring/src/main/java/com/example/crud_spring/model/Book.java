package com.example.crud_spring.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    @Column(name = "book_name")
    private String book_name;

    @ManyToOne
    @JoinColumn(name = "stud_id")
    private Student student;

    public Book(String book_name, Student student) {
        this.book_name = book_name;
        this.student = student;
    }

    public Book() {
    }
}
