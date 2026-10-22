package com.edsonmiguel.gestao_vagas.module.company.useCase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.edsonmiguel.gestao_vagas.module.company.exception.CompanyAlreadyExistsException;
import com.edsonmiguel.gestao_vagas.module.company.entity.CompanyEntity;
import com.edsonmiguel.gestao_vagas.module.company.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCase {

  private final CompanyRepository companyRepository;

  private final PasswordEncoder passwordEncoder;

  public CompanyEntity execute(CompanyEntity company) {
    this.companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail()).ifPresent((user) -> {
      throw new CompanyAlreadyExistsException();
    });

    var password = this.passwordEncoder.encode(company.getPassword());
    company.setPassword(password);
    return this.companyRepository.save(company);
  }

}
