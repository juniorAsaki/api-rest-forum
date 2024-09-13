package com.ada.ci.api_rest_forum.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {

    private Long idSubject;

    private String title;

    private ForumDTO forum;

    private String slug;
}
