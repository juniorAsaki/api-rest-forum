package com.ada.ci.api_rest_forum.services;

import com.ada.ci.api_rest_forum.services.dto.SujetDTO;

import java.util.List;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);
    List<SujetDTO> findAllByForum(Long id);
    SujetDTO getSujet(Long id);
}
