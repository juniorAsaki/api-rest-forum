package com.ada.ci.api_rest_forum.repositories;

import com.ada.ci.api_rest_forum.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByForum_IdForum(Long id);
}
