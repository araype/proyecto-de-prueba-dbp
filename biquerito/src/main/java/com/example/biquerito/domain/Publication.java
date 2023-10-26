package com.example.biquerito.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Transient
    private Long userIdTransient;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file")
    private String file;

    public Publication() {
    }

    public Publication(User user, String category, String title, String description, String file) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.description = description;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getFile() {
        return file;
    }

    public Long getUserIdTransient() {
        return userIdTransient;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
