package com.edsonmiguel.gestao_vagas.module.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.company.dto.AuthCompanyRequestDTO;
import com.edsonmiguel.gestao_vagas.module.company.dto.AuthCompanyResponseDTO;
import com.edsonmiguel.gestao_vagas.module.company.useCase.AuthCompanyUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCompanyController {

  private final AuthCompanyUseCase authCompanyUseCase;

  @PostMapping("/company")
  public AuthCompanyResponseDTO authenticate(@Valid @RequestBody AuthCompanyRequestDTO request) {
    var token = authCompanyUseCase.execute(request);
    return new AuthCompanyResponseDTO(token, "Bearer");
  }

}
