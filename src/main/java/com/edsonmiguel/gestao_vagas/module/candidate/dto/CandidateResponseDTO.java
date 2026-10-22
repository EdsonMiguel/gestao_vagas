package com.edsonmiguel.gestao_vagas.module.candidate.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.edsonmiguel.gestao_vagas.module.candidate.entity.CandidateEntity;

public record CandidateResponseDTO(
    UUID id,
    String name,
    String username,
    String email,
    String description,
    String curriculum,
    LocalDateTime createdAt) {

  public static CandidateResponseDTO from(CandidateEntity candidate) {
    return new CandidateResponseDTO(
        candidate.getId(),
        candidate.getName(),
        candidate.getUsername(),
        candidate.getEmail(),
        candidate.getDescription(),
        candidate.getCurriculum(),
        candidate.getCreatedAt());
  }
}
