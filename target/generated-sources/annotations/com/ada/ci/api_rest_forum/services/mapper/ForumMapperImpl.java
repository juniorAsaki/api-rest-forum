package com.ada.ci.api_rest_forum.services.mapper;

import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T17:06:05-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class ForumMapperImpl implements ForumMapper {

    @Override
    public ForumDTO ToDto(Forum entity) {
        if ( entity == null ) {
            return null;
        }

        ForumDTO forumDTO = new ForumDTO();

        forumDTO.setIdForum( entity.getIdForum() );
        forumDTO.setTitle( entity.getTitle() );
        forumDTO.setDescription( entity.getDescription() );
        forumDTO.setCreatedDate( entity.getCreatedDate() );
        forumDTO.setSlug( entity.getSlug() );

        return forumDTO;
    }

    @Override
    public Forum DtoToEntity(ForumDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Forum forum = new Forum();

        forum.setIdForum( dto.getIdForum() );
        forum.setTitle( dto.getTitle() );
        forum.setDescription( dto.getDescription() );
        forum.setCreatedDate( dto.getCreatedDate() );
        forum.setSlug( dto.getSlug() );

        return forum;
    }
}
