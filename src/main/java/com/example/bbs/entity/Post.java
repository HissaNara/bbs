
package com.example.bbs.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String postedAt;

    @PrePersist
    protected void onCreate() {
        this.postedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getContent() { return content; }
    public String getPostedAt() { return postedAt; }

    public void setName(String name) { this.name = name; }
    public void setContent(String content) { this.content = content; }
}
