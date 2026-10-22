package com.edsonmiguel.gestao_vagas.module.company.exception;

public class CompanyNotFoundException extends RuntimeException {
  public CompanyNotFoundException() {
    super("Empresa não encontrada");
  }
}
