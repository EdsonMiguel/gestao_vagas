package com.edsonmiguel.gestao_vagas.module.company.exception;

import org.springframework.http.HttpStatus;

import com.edsonmiguel.gestao_vagas.exception.BusinessException;

public class CompanyNotFoundException extends BusinessException {
  public CompanyNotFoundException() {
    super(HttpStatus.NOT_FOUND, "Empresa não encontrada.");
  }
}
