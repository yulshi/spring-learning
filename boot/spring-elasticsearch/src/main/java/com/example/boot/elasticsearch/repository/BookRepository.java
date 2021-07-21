package com.example.boot.elasticsearch.repository;

import com.example.boot.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yulshi
 * @create 2020/06/13 18:30
 */
//@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findBooksByName(String name);

}
