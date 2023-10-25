package com.example.biquerito.reaction.domain;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    public List<Reaction> findByPublicationId(Long publicationId);
}
