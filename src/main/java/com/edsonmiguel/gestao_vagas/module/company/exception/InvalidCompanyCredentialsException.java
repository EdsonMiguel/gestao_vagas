package com.edsonmiguel.gestao_vagas.module.company.exception;

import org.springframework.http.HttpStatus;

import com.edsonmiguel.gestao_vagas.exception.BusinessException;

public class InvalidCompanyCredentialsException extends BusinessException {

  public InvalidCompanyCredentialsException() {
    super(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos.");
  }
}
