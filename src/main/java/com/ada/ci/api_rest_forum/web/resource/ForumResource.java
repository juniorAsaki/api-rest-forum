package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.ForumService;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/forums")
public class ForumResource {

    private final ForumService forumService;

    public ForumResource(ForumService forumService) {
        this.forumService = forumService;
    }

    @PostMapping
    public ResponseEntity<ForumDTO> createForum(@RequestBody ForumDTO forumDTO) throws URISyntaxException {
        if (forumDTO.getIdForum() != null) {
            return ResponseEntity.badRequest().body(null); // L'entité ne doit pas déjà avoir un ID.
        }
        forumDTO.setCreatedDate(Instant.now());
        ForumDTO forumSave = forumService.save(forumDTO);
        return ResponseEntity.created(new URI("/api/forums/" + forumSave.getIdForum())).body(forumSave);
    }


    @GetMapping
    public ResponseEntity<List<ForumDTO>> getAllForums() {
        List<ForumDTO> forums = forumService.findAll();
        return ResponseEntity.ok(forums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumDTO> getForum(@PathVariable Long id) {
        Optional<ForumDTO> forumDTO = forumService.findOne(id);
        return forumDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
