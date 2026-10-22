package com.edsonmiguel.gestao_vagas.module.company.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthCompanyDTO(
    @NotBlank String username,
    @NotBlank String password) {
}