package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.SujetService;
import com.ada.ci.api_rest_forum.services.dto.SujetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sujets")
@Slf4j
@RequiredArgsConstructor
public class SujetResource {

    private final SujetService sujetService;

    @PostMapping
    public ResponseEntity<SujetDTO> saveSujet(@RequestBody SujetDTO sujetDTO) {
        log.debug("REST request to save Sujet : {}", sujetDTO);
        return new ResponseEntity<>(sujetService.save(sujetDTO) , HttpStatus.CREATED);
    }

    @GetMapping("/forum/{id}")
    public ResponseEntity<List<SujetDTO>> getSujets(@PathVariable Long id) {
        log.debug("REST request to get Sujet : {}", id);
        return new ResponseEntity<>(sujetService.findAllByForum(id) , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SujetDTO> getSujet(@PathVariable Long id) {
        log.debug("REST request to get Sujet : {}", id);

        return new ResponseEntity<>(sujetService.getSujet(id), HttpStatus.OK);
    }
}
