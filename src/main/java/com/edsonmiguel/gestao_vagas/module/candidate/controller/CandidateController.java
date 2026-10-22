package com.edsonmiguel.gestao_vagas.module.candidate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.candidate.dto.CandidateRequestDTO;
import com.edsonmiguel.gestao_vagas.module.candidate.dto.CandidateResponseDTO;
import com.edsonmiguel.gestao_vagas.module.candidate.useCase.CreateCandidateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {

  private final CreateCandidateUseCase createCandidateUseCase;

  @PostMapping
  public CandidateResponseDTO create(@Valid @RequestBody CandidateRequestDTO request) {
    var candidate = this.createCandidateUseCase.execute(request.toEntity());
    return CandidateResponseDTO.from(candidate);
  }
}
