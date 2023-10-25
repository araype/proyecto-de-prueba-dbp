package com.example.demo.session.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    // este método busca una sesión por el email del usuario
    Session findByEmail(String email);

    // este método borra una sesión por el email del usuario
    void deleteByEmail(String email);
}
