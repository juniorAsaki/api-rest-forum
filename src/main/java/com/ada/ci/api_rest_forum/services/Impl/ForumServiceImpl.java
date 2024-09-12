package com.ada.ci.api_rest_forum.services.Impl;


import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.repositories.ForumRepository;
import com.ada.ci.api_rest_forum.services.ForumService;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import com.ada.ci.api_rest_forum.services.mapper.ForumMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    public ForumServiceImpl(ForumRepository forumRepository, ForumMapper forumMapper) {
        this.forumRepository = forumRepository;
        this.forumMapper = forumMapper;
    }

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        Forum forum = forumMapper.DtoToEntity(forumDTO);
        forum = forumRepository.save(forum);
        return forumMapper.ToDto(forum);
    }

    @Override
    public List<ForumDTO> findAll() {
        return forumRepository.findAll().stream()
                .map(forumMapper::ToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ForumDTO> findOne(Long id) {
        return forumRepository.findById(id)
                .map(forumMapper::ToDto);
    }

    @Override
    public void delete(Long id) {
        forumRepository.deleteById(id);
    }
}
