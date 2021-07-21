package com.example.boot.elasticsearch.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author yulshi
 * @create 2020/06/13 23:18
 */
@Document(indexName = "articals")
public class Artical {

    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Artical{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
