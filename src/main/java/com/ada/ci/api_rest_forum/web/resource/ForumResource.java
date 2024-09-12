package com.ada.ci.api_rest_forum.web.resource;


import com.ada.ci.api_rest_forum.services.ForumService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/forums")
public class ForumResource {

    private final ForumService forumService;

    public ForumResource(ForumService forumService) {
        this.forumService = forumService;
    }

    @PostMapping
    public ResponseEntity<ForumDTO> createForum(@RequestBody ForumDTO forumDTO) throws URISyntaxException {
        if (forumDTO.getIdForum != null) {
            return ResponseEntity.badRequest().body(null); // L'entité ne doit pas déjà avoir un ID.
        }
        ForumDTO result = forumService.save(forumDTO);
        return ResponseEntity.created(new URI("/api/forums/" + result.getIdForum())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumDTO> updateForum(@PathVariable Long id, @RequestBody ForumDTO forumDTO) {
        if (!id.equals(forumDTO.getIdForum())) {
            return ResponseEntity.badRequest().body(null);
        }
        ForumDTO result = forumService.save(forumDTO);
        return ResponseEntity.ok(result);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForum(@PathVariable Long id) {
        forumService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
