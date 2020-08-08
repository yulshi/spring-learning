package com.example.amqp.controller;

import com.example.amqp.bean.Book;
import com.example.amqp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yulshi
 * @create 2020/06/08 18:13
 */
@RestController
public class BookController {

  @Autowired
  BookService messageSender;

  @GetMapping("/book/add")
  public String addBook(Book book) {
    System.out.println("Preparing to add book: " + book);
    messageSender.addBook(book);
    return "success";
  }



}
