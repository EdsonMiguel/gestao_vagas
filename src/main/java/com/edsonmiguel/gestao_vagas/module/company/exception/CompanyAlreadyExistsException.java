package com.edsonmiguel.gestao_vagas.module.company.exception;

public class CompanyAlreadyExistsException extends RuntimeException {
  public CompanyAlreadyExistsException() {
    super("Já existe uma empresa cadastrada com este e-mail ou nome de usuário.");
  }
}
