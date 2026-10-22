package com.edsonmiguel.gestao_vagas.module.company.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.module.company.dto.CompanyRequestDTO;
import com.edsonmiguel.gestao_vagas.module.company.dto.CompanyResponseDTO;
import com.edsonmiguel.gestao_vagas.module.company.useCase.CreateCompanyUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

  private final CreateCompanyUseCase createCompanyUseCase;

  @PostMapping
  public CompanyResponseDTO create(@Valid @RequestBody CompanyRequestDTO request) {
    var company = this.createCompanyUseCase.execute(request.toEntity());
    return CompanyResponseDTO.from(company);
  }

}
