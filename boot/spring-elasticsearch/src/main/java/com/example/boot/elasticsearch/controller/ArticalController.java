package com.example.boot.elasticsearch.controller;

import com.example.boot.elasticsearch.bean.Artical;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;

/**
 * @author yulshi
 * @create 2020/06/13 23:42
 */
@RestController
public class ArticalController {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public ArticalController(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @GetMapping("/artical/add")
    public void addArtical(Artical artical) {
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(artical).build();
        elasticsearchTemplate.index(indexQuery);
    }

    @GetMapping("/artical/query")
    public List<Artical> queryByContent(String key) {
        QueryBuilder queryBuilder = new SimpleQueryStringBuilder(key);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
        List<Artical> articals = elasticsearchTemplate.queryForList(searchQuery, Artical.class);
        return articals;
    }
}
