package com.ada.ci.api_rest_forum.services.mapper;

import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.models.Subject;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T17:22:16-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectDTO ToDto(Subject entity) {
        if ( entity == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setIdSubject( entity.getIdSubject() );
        subjectDTO.setTitle( entity.getTitle() );
        subjectDTO.setForum( forumToForumDTO( entity.getForum() ) );
        subjectDTO.setSlug( entity.getSlug() );

        return subjectDTO;
    }

    @Override
    public Subject DtoToEntity(SubjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setIdSubject( dto.getIdSubject() );
        subject.setTitle( dto.getTitle() );
        subject.setForum( forumDTOToForum( dto.getForum() ) );
        subject.setSlug( dto.getSlug() );

        return subject;
    }

    protected ForumDTO forumToForumDTO(Forum forum) {
        if ( forum == null ) {
            return null;
        }

        ForumDTO forumDTO = new ForumDTO();

        forumDTO.setIdForum( forum.getIdForum() );
        forumDTO.setTitle( forum.getTitle() );
        forumDTO.setDescription( forum.getDescription() );
        forumDTO.setCreatedDate( forum.getCreatedDate() );
        forumDTO.setSlug( forum.getSlug() );

        return forumDTO;
    }

    protected Forum forumDTOToForum(ForumDTO forumDTO) {
        if ( forumDTO == null ) {
            return null;
        }

        Forum forum = new Forum();

        forum.setIdForum( forumDTO.getIdForum() );
        forum.setTitle( forumDTO.getTitle() );
        forum.setDescription( forumDTO.getDescription() );
        forum.setCreatedDate( forumDTO.getCreatedDate() );
        forum.setSlug( forumDTO.getSlug() );

        return forum;
    }
}
