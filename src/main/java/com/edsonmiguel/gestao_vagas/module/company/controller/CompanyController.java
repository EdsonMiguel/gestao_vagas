package com.edsonmiguel.gestao_vagas.module.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.company.entity.CompanyEntity;
import com.edsonmiguel.gestao_vagas.module.company.useCase.CreateCompanyUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

  private final CreateCompanyUseCase createCompanyUseCase;

  @PostMapping
  public CompanyEntity create(@Valid @RequestBody CompanyEntity company) {
    return this.createCompanyUseCase.execute(company);
  }

}
