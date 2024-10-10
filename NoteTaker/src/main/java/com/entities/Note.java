package com.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Random;

@Entity
public class Note {
    @Id
    private int id;
    private String title;

    @Column(length = 2000)
    private String content;
    private Date addedDate;

    public Note() {
    }

    public Note(String title, String content, Date addedDate) {
        this.id = new Random().nextInt(100000);
        this.title = title;
        this.content = content;
        this.addedDate = addedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
