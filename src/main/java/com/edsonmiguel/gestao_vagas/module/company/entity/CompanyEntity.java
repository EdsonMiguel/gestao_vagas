package com.edsonmiguel.gestao_vagas.module.company.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "companies")
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "Informe o nome da empresa.")
  private String name;

  @NotBlank(message = "Informe um nome de usuário para a empresa.")
  private String username;

  @NotBlank(message = "Informe o e-mail da empresa.")
  @Email(message = "Informe um endereço de e-mail válido para a empresa.")
  private String email;

  @NotBlank(message = "Informe uma senha para a empresa.")
  private String password;
  private String website;
  private String description;

  @CreationTimestamp
  private LocalDate createdAt;
}
