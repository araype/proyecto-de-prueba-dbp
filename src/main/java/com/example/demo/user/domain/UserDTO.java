package com.example.demo.user.domain;
import jakarta.validation.constraints.NotNull;
import java.lang.annotation.Native;

public class UserDTO {
    @NotNull( message = "El email no puede ser nulo")
    private String email;
    @NotNull( message = "La contraseña no puede ser nula")
    private String password;
    public UserDTO() {
    }

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
