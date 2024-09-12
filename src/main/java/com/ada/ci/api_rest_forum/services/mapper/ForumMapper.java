package com.ada.ci.api_rest_forum.services.mapper;

import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;

public interface ForumMapper {
    Forum DtoToEntity(ForumDTO forumDTO);

    ForumDTO ToDto(Forum forum);
}
