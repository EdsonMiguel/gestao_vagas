package com.edsonmiguel.gestao_vagas.exceptions;

public class UserAlreadyExistsExceptions extends RuntimeException {
  public UserAlreadyExistsExceptions() {
    super("Usuário já existe");
  }
}
