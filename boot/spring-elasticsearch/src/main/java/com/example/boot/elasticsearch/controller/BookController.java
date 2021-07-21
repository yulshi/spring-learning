package com.example.boot.elasticsearch.controller;

import com.example.boot.elasticsearch.bean.Book;
import com.example.boot.elasticsearch.repository.BookRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author yulshi
 * @create 2020/06/13 18:32
 */
@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book/add")
    public String addBook(Book book) {

//    Book book = new Book();
//    book.setId(1);
//    book.setName("三国演义");
//    book.setAuthor("罗贯中");
        bookRepository.index(book);

        return "saved";
    }

    @GetMapping("/book/query")
    public List<Book> queryBooksInAuthor(@RequestParam("key") String keyword) {

        QueryBuilder queryBuilder = new MatchQueryBuilder("author", keyword);
        Iterable<Book> iterable = bookRepository.search(queryBuilder);
        List<Book> books = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        return books;
    }

}
