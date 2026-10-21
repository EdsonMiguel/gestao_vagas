package com.edsonmiguel.gestao_vagas.module.candidate.exception;

public class CandidateAlreadyExistsException extends RuntimeException {
  public CandidateAlreadyExistsException() {
    super("Já existe um usuário com essas informações");
  }
}
