package com.edsonmiguel.gestao_vagas.module.company.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "jobs")
public class JobEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String description;
  private String benefits;
  private String level;

  @ManyToOne
  @JoinColumn(name = "comapny_id", insertable = false, updatable = false)
  private CompanyEntity company;

  @Column(name = "comapny_id", nullable = false)
  private UUID companyId;

  @CreationTimestamp
  private LocalDate createdAt;
}
