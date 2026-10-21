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

  @NotBlank
  private String name;

  @NotBlank
  @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "O campo [username] deve conter apenas letras, números.")
  private String username;

  @NotBlank
  @Email(message = "O campo [email] deve ser um endereço de e-mail válido.")
  private String email;

  @NotBlank
  @Length(min = 8, message = "O campo [password] deve ter no mínimo 8 caracteres.")
  private String password;

  private String description;
  private String curriculum;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
