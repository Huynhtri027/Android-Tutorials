package com.example.kerem.sqlitedeneme;

/**
 * Created by Kerem on 01.11.2017.
 */

public class User {
    private String title;
    private String content;

    public User(){

    }

    public User(String title, String content){
        this.title=title;
        this.content=content;
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
}
