package com.edsonmiguel.gestao_vagas.module.company.useCase;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.edsonmiguel.gestao_vagas.module.company.dto.AuthCompanyDTO;
import com.edsonmiguel.gestao_vagas.module.company.exception.CompanyNotFoundException;
import com.edsonmiguel.gestao_vagas.module.company.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthCompanyUseCase {

  private final CompanyRepository companyRepository;

  private final PasswordEncoder passwordEncoder;

  @Value("${security.token.secret}")
  private String secretKey;

  public String execute(AuthCompanyDTO autCompay) {
    var company = companyRepository.findByUsername(autCompay.username()).orElseThrow(() -> {
      throw new CompanyNotFoundException();
    });

    var passwordMatches = this.passwordEncoder.matches(autCompay.password(), company.getPassword());

    if (!passwordMatches) {
      throw new RuntimeException("Outro Erro");
    }

    Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

    var token = JWT.create().withIssuer("javagas").withSubject(company.getId().toString())
        .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
        .sign(algorithm);

    return token;

  }
}
