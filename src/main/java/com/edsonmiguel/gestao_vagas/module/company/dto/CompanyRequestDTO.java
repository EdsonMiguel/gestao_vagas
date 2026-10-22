package com.edsonmiguel.gestao_vagas.module.company.dto;

import com.edsonmiguel.gestao_vagas.module.company.entity.CompanyEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompanyRequestDTO(
    @NotBlank(message = "Informe o nome da empresa.") String name,
    @NotBlank(message = "Informe um nome de usuário para a empresa.") String username,
    @NotBlank(message = "Informe o e-mail da empresa.")
    @Email(message = "Informe um endereço de e-mail válido para a empresa.") String email,
    @NotBlank(message = "Informe uma senha para a empresa.")
    @Size(min = 8, message = "A senha deve conter pelo menos 8 caracteres.") String password,
    String website,
    String description) {

  public CompanyEntity toEntity() {
    var company = new CompanyEntity();
    company.setName(name);
    company.setUsername(username);
    company.setEmail(email);
    company.setPassword(password);
    company.setWebsite(website);
    company.setDescription(description);
    return company;
  }
}
