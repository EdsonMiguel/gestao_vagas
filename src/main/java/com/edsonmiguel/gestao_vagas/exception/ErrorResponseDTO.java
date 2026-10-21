package com.edsonmiguel.gestao_vagas.exception;

import java.time.Instant;

public record ErrorResponseDTO(int status, String description, Instant timestamp) {
}
