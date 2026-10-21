package com.edsonmiguel.gestao_vagas.modules.candidate.useCases;

import org.springframework.stereotype.Service;

import com.edsonmiguel.gestao_vagas.exceptions.UserAlreadyExistsExceptions;
import com.edsonmiguel.gestao_vagas.modules.candidate.CandidateEntity;
import com.edsonmiguel.gestao_vagas.modules.candidate.CandidateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCandidateUseCase {

  private CandidateRepository candidateRepository;

  public CandidateEntity execute(CandidateEntity candidate) {
    this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(),
        candidate.getEmail()).ifPresent(user -> {
          throw new UserAlreadyExistsExceptions();
        });
    return this.candidateRepository.save(candidate);
  }
}
