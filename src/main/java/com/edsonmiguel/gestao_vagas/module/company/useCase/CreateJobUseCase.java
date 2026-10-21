package com.edsonmiguel.gestao_vagas.module.company.useCase;

import org.springframework.stereotype.Service;

import com.edsonmiguel.gestao_vagas.module.company.entity.JobEntity;
import com.edsonmiguel.gestao_vagas.module.company.repository.JobRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateJobUseCase {

  private final JobRepository jobRepository;

  public JobEntity execute(JobEntity job) {
    return this.jobRepository.save(job);
  }
}
