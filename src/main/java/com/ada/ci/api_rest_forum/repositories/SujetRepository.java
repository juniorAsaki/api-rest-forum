package com.ada.ci.api_rest_forum.repositories;

import com.ada.ci.api_rest_forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    Sujet findByForum(Long id);
}
