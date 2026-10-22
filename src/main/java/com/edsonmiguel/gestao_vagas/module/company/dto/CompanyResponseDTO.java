package com.edsonmiguel.gestao_vagas.module.company.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.edsonmiguel.gestao_vagas.module.company.entity.CompanyEntity;

public record CompanyResponseDTO(
    UUID id,
    String name,
    String username,
    String email,
    String website,
    String description,
    LocalDate createdAt) {

  public static CompanyResponseDTO from(CompanyEntity company) {
    return new CompanyResponseDTO(
        company.getId(),
        company.getName(),
        company.getUsername(),
        company.getEmail(),
        company.getWebsite(),
        company.getDescription(),
        company.getCreatedAt());
  }
}
