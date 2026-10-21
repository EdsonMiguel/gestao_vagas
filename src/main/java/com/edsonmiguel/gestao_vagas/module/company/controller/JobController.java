package com.edsonmiguel.gestao_vagas.module.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.company.entity.JobEntity;
import com.edsonmiguel.gestao_vagas.module.company.useCase.CreateJobUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

  private final CreateJobUseCase createJobUseCase;

  @PostMapping
  public JobEntity create(@Valid @RequestBody JobEntity job) {
    return this.createJobUseCase.execute(job);
  }

}
