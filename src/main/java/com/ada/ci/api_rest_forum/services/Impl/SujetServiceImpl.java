package com.ada.ci.api_rest_forum.services.Impl;

import com.ada.ci.api_rest_forum.repositories.SujetRepository;
import com.ada.ci.api_rest_forum.services.SujetService;
import com.ada.ci.api_rest_forum.services.dto.SujetDTO;
import com.ada.ci.api_rest_forum.services.mapper.SujetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;

    private final SujetMapper sujetMapper;

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        return sujetMapper.ToDto(sujetRepository.save(sujetMapper.DtoToEntity(sujetDTO)));
    }

    @Override
    public List<SujetDTO> findByForum(Long forumId) {
        return Collections.singletonList(sujetMapper.ToDto(sujetRepository.findByForum(forumId)));
    }


}
