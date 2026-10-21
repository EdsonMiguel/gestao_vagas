package com.edsonmiguel.gestao_vagas.module.company.exception;

public class CompanyAlreadyExistsException extends RuntimeException {
  public CompanyAlreadyExistsException() {
    super("Já existe um usuário com essas informações");
  }
}
