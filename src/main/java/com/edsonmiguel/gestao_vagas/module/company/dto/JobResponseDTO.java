package com.edsonmiguel.gestao_vagas.module.company.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.edsonmiguel.gestao_vagas.module.company.entity.JobEntity;

public record JobResponseDTO(
    UUID id,
    String description,
    String benefits,
    String level,
    UUID companyId,
    LocalDate createdAt) {

  public static JobResponseDTO from(JobEntity job) {
    return new JobResponseDTO(
        job.getId(),
        job.getDescription(),
        job.getBenefits(),
        job.getLevel(),
        job.getCompanyId(),
        job.getCreatedAt());
  }
}
