package com.ada.ci.api_rest_forum.services;

import com.ada.ci.api_rest_forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);
    List<SujetDTO> findByForum(Long forumId);
}
