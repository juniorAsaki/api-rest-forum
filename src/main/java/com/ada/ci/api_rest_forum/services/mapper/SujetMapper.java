package com.ada.ci.api_rest_forum.services.mapper;

import com.ada.ci.api_rest_forum.models.Sujet;
import com.ada.ci.api_rest_forum.services.dto.SujetDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SujetMapper extends EntityMapper<SujetDTO , Sujet>{
}
