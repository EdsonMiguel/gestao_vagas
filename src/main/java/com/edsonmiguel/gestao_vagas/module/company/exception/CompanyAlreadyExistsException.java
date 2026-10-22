package com.edsonmiguel.gestao_vagas.module.company.exception;

import org.springframework.http.HttpStatus;

import com.edsonmiguel.gestao_vagas.exception.BusinessException;

public class CompanyAlreadyExistsException extends BusinessException {
  public CompanyAlreadyExistsException() {
    super(HttpStatus.CONFLICT, "Já existe uma empresa cadastrada com este e-mail ou nome de usuário.");
  }
}
