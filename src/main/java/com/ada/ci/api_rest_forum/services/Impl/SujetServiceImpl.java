package com.ada.ci.api_rest_forum.services.Impl;

import com.ada.ci.api_rest_forum.repositories.SujetRepository;
import com.ada.ci.api_rest_forum.services.SujetService;
import com.ada.ci.api_rest_forum.services.dto.SujetDTO;
import com.ada.ci.api_rest_forum.services.mapper.SujetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;

    private final SujetMapper sujetMapper;

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        return sujetMapper.ToDto(sujetRepository.save(sujetMapper.DtoToEntity(sujetDTO)));
    }

    @Override
    public List<SujetDTO> findAll() {
        return sujetRepository.findAll().stream().map(sujetMapper::ToDto).toList();
    }

    @Override
    public Optional<SujetDTO> findOne(Long id) {
        return sujetRepository.findById(id).map(sujetMapper::ToDto);
    }

    @Override
    public void delete(Long id) {
        sujetRepository.deleteById(id);
    }

    @Override
    public SujetDTO update(SujetDTO sujetDTO) {
        return findOne(sujetDTO.getIdSujet()).map(existingSujet ->{
            existingSujet.setTitle(sujetDTO.getTitle());
            return existingSujet;
        }).orElseThrow(()-> new IllegalArgumentException("Sujet id not found"));
    }
}
