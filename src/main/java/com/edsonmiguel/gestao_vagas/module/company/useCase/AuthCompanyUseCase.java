package com.edsonmiguel.gestao_vagas.module.company.useCase;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.edsonmiguel.gestao_vagas.module.company.dto.AuthCompanyRequestDTO;
import com.edsonmiguel.gestao_vagas.module.company.exception.InvalidCompanyCredentialsException;
import com.edsonmiguel.gestao_vagas.module.company.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthCompanyUseCase {

  private final CompanyRepository companyRepository;

  private final PasswordEncoder passwordEncoder;

  @Value("${security.token.secret}")
  private String secretKey;

  public String execute(AuthCompanyRequestDTO authCompany) {
    var company = companyRepository.findByUsername(authCompany.username())
        .orElseThrow(InvalidCompanyCredentialsException::new);

    var passwordMatches = this.passwordEncoder.matches(authCompany.password(), company.getPassword());

    if (!passwordMatches) {
      throw new InvalidCompanyCredentialsException();
    }

    Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

    var token = JWT.create().withIssuer("javagas").withSubject(company.getId().toString())
        .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
        .sign(algorithm);

    return token;

  }
}
