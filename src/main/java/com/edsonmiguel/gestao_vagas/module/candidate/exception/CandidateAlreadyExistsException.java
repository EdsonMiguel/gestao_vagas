package com.edsonmiguel.gestao_vagas.module.candidate.exception;

public class CandidateAlreadyExistsException extends RuntimeException {
  public CandidateAlreadyExistsException() {
    super("Já existe uma conta de candidato com este e-mail ou nome de usuário.");
  }
}
