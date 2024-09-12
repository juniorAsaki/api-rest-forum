package com.ada.ci.api_rest_forum.services.dto;

import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.models.Message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SujetDTO {

    private Long idSujet;

    private String title;

    private ForumDTO forum;

    private MessageDTO message;

    private String slug;
}
