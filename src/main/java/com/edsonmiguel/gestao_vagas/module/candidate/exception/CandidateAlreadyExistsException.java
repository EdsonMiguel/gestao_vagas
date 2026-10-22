package com.edsonmiguel.gestao_vagas.module.candidate.exception;

import org.springframework.http.HttpStatus;

import com.edsonmiguel.gestao_vagas.exception.BusinessException;

public class CandidateAlreadyExistsException extends BusinessException {
  public CandidateAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "Já existe uma conta de candidato com este e-mail ou nome de usuário.");
  }
}
