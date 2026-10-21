package com.edsonmiguel.gestao_vagas.module.company.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edsonmiguel.gestao_vagas.module.company.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
