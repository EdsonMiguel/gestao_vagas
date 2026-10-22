package com.edsonmiguel.gestao_vagas.module.company.dto;

import com.edsonmiguel.gestao_vagas.module.company.entity.JobEntity;

import jakarta.validation.constraints.NotBlank;

public record JobRequestDTO(
    @NotBlank(message = "Informe a descrição da vaga.") String description,
    @NotBlank(message = "Informe os benefícios da vaga.") String benefits,
    @NotBlank(message = "Informe o nível da vaga.") String level) {

  public JobEntity toEntity() {
    var job = new JobEntity();
    job.setDescription(description);
    job.setBenefits(benefits);
    job.setLevel(level);
    return job;
  }
}
