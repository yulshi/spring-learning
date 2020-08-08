package com.example.boot.elasticsearch.service;

import com.example.boot.elasticsearch.bean.Artical;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

/**
 * @author yulshi
 * @create 2020/06/13 23:17
 */
public class BookService {

  private final ElasticsearchTemplate esTemplate;

  public BookService(ElasticsearchTemplate esTemplate) {
    this.esTemplate = esTemplate;
  }

  public void addArtical(Artical artical) {
    IndexQuery indexQuery = new IndexQueryBuilder().withObject(artical).build();
    esTemplate.index(indexQuery);
  }


}
