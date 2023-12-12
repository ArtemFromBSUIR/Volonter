package com.example.Volonter.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "full_text")
    private String fullText;

    @Column(name = "anons")
    private String anons;

    @Column(name = "views")
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
