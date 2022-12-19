package com.example.demo.jsonplaceholder;

import lombok.Data;

//@Data It is super annotation as set public constructor, getters, setters & toString functions.
@Data
public class Post {
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;
    /*
    public Post(Integer userId,Integer id,String title,String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }*/
}
