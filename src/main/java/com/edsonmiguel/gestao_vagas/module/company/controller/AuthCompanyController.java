package com.edsonmiguel.gestao_vagas.module.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.company.dto.AuthCompanyDTO;
import com.edsonmiguel.gestao_vagas.module.company.useCase.AuthCompanyUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCompanyController {

  public final AuthCompanyUseCase authCompanyUseCase;

  @PostMapping("/company")
  public String authenticate(@Valid @RequestBody AuthCompanyDTO company) {
    System.out.println(company);
    return authCompanyUseCase.execute(company);
  }

}
