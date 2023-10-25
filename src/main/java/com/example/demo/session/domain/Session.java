package com.example.demo.session.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Almacena email del usuario que se va a logear
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    // Almacenará si es que está logeado o no
    @Column(name = "logged_in", nullable = false)
    private boolean loggedIn;
    public Session() {

    }

    public Session(String email, boolean loggedIn) {
        this.email = email;
        this.loggedIn = loggedIn;
    }

    public String getEmail() {
        return email;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
