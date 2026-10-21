package com.edsonmiguel.gestao_vagas.module.candidate.useCase;

import org.springframework.stereotype.Service;

import com.edsonmiguel.gestao_vagas.module.candidate.entity.CandidateEntity;
import com.edsonmiguel.gestao_vagas.module.candidate.exception.CandidateAlreadyExistsException;
import com.edsonmiguel.gestao_vagas.module.candidate.repository.CandidateRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCandidateUseCase {

  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidate) {
    this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(),
        candidate.getEmail()).ifPresent(user -> {
          throw new CandidateAlreadyExistsException();
        });
    return this.candidateRepository.save(candidate);
  }
}
