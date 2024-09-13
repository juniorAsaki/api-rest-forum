package com.ada.ci.api_rest_forum.services.mapper;

import com.ada.ci.api_rest_forum.models.Forum;
import com.ada.ci.api_rest_forum.models.Message;
import com.ada.ci.api_rest_forum.models.Subject;
import com.ada.ci.api_rest_forum.services.dto.ForumDTO;
import com.ada.ci.api_rest_forum.services.dto.MessageDTO;
import com.ada.ci.api_rest_forum.services.dto.SubjectDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T17:06:05-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public MessageDTO ToDto(Message entity) {
        if ( entity == null ) {
            return null;
        }

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setIdMessage( entity.getIdMessage() );
        messageDTO.setContent( entity.getContent() );
        messageDTO.setCreatedDate( entity.getCreatedDate() );
        messageDTO.setSubject( subjectToSubjectDTO( entity.getSubject() ) );
        messageDTO.setSlug( entity.getSlug() );

        return messageDTO;
    }

    @Override
    public Message DtoToEntity(MessageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setIdMessage( dto.getIdMessage() );
        message.setContent( dto.getContent() );
        message.setCreatedDate( dto.getCreatedDate() );
        message.setSubject( subjectDTOToSubject( dto.getSubject() ) );
        message.setSlug( dto.getSlug() );

        return message;
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

    protected SubjectDTO subjectToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        subjectDTO.setIdSubject( subject.getIdSubject() );
        subjectDTO.setTitle( subject.getTitle() );
        subjectDTO.setForum( forumToForumDTO( subject.getForum() ) );
        subjectDTO.setSlug( subject.getSlug() );

        return subjectDTO;
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

    protected Subject subjectDTOToSubject(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setIdSubject( subjectDTO.getIdSubject() );
        subject.setTitle( subjectDTO.getTitle() );
        subject.setForum( forumDTOToForum( subjectDTO.getForum() ) );
        subject.setSlug( subjectDTO.getSlug() );

        return subject;
    }
}
