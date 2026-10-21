package com.edsonmiguel.gestao_vagas.module.candidate.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidates")
public class CandidateEntity {

  @Id()
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "Informe seu nome.")
  private String name;

  @NotBlank(message = "Informe um nome de usuário.")
  @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "O nome de usuário deve conter apenas letras, números ou sublinhado (_).")
  private String username;

  @NotBlank(message = "Informe seu e-mail.")
  @Email(message = "Informe um endereço de e-mail válido.")
  private String email;

  @NotBlank(message = "Informe uma senha.")
  @Length(min = 8, message = "A senha deve conter pelo menos 8 caracteres.")
  private String password;

  private String description;
  private String curriculum;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
