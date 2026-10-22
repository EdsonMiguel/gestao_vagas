package com.edsonmiguel.gestao_vagas.module.company.controller;

import java.util.UUID;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.company.dto.JobRequestDTO;
import com.edsonmiguel.gestao_vagas.module.company.dto.JobResponseDTO;
import com.edsonmiguel.gestao_vagas.module.company.useCase.CreateJobUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

  private final CreateJobUseCase createJobUseCase;

  @PostMapping
  public JobResponseDTO create(@Valid @RequestBody JobRequestDTO request,
      @AuthenticationPrincipal String companyId) {
    var job = request.toEntity();
    job.setCompanyId(UUID.fromString(companyId));
    return JobResponseDTO.from(this.createJobUseCase.execute(job));
  }

}
