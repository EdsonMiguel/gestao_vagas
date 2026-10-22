package com.edsonmiguel.gestao_vagas.module.company.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthCompanyRequestDTO(
    @NotBlank(message = "Informe o nome de usuário da empresa.") String username,
    @NotBlank(message = "Informe sua senha.") String password) {
}
