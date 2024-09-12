package com.ada.ci.api_rest_forum.services.Impl;

import com.ada.ci.api_rest_forum.repositories.MessageRepository;
import com.ada.ci.api_rest_forum.services.MessageService;
import com.ada.ci.api_rest_forum.services.dto.MessageDTO;
import com.ada.ci.api_rest_forum.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        return messageMapper.ToDto(messageRepository.save(messageMapper.DtoToEntity(messageDTO)));
    }

    @Override
    public List<MessageDTO> findAllByIdSujet(Long id) {
        return List.of();
    }
}
