package com.edsonmiguel.gestao_vagas.module.candidate.dto;

import com.edsonmiguel.gestao_vagas.module.candidate.entity.CandidateEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CandidateRequestDTO(
    @NotBlank(message = "Informe seu nome.") String name,
    @NotBlank(message = "Informe um nome de usuário.")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "O nome de usuário deve conter apenas letras, números ou sublinhado (_).") String username,
    @NotBlank(message = "Informe seu e-mail.")
    @Email(message = "Informe um endereço de e-mail válido.") String email,
    @NotBlank(message = "Informe uma senha.")
    @Size(min = 8, message = "A senha deve conter pelo menos 8 caracteres.") String password,
    String description,
    String curriculum) {

  public CandidateEntity toEntity() {
    var candidate = new CandidateEntity();
    candidate.setName(name);
    candidate.setUsername(username);
    candidate.setEmail(email);
    candidate.setPassword(password);
    candidate.setDescription(description);
    candidate.setCurriculum(curriculum);
    return candidate;
  }
}
