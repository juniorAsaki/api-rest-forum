package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.MessageService;
import com.ada.ci.api_rest_forum.services.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
@Slf4j
public class MessageResource {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        log.debug("REST request to save Message : {}", messageDTO);
        messageDTO.setCreatedDate(Instant.now());
        return new ResponseEntity<>(messageService.save(messageDTO) , HttpStatus.CREATED);
    }
}
