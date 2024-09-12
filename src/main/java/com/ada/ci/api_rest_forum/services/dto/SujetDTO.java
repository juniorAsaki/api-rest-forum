package com.ada.ci.api_rest_forum.services.dto;

import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.models.Message;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SujetDTO {

    private Long idSujet;

    private String title;

    private ForumDTO forum;

//    private List<MessageDTO> messages;

    private String slug;
}
