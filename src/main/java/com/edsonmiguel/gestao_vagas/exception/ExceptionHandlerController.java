package com.edsonmiguel.gestao_vagas.exception;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

  private final MessageSource messageSource;

  public ExceptionHandlerController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    String description = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> messageSource.getMessage(error, LocaleContextHolder.getLocale()))
        .collect(Collectors.joining(" ", "Não foi possível validar os dados enviados: ", ""));

    return errorResponse(HttpStatus.BAD_REQUEST, description);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponseDTO> handleBusinessException(BusinessException ex) {
    return errorResponse(ex.getStatus(), ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleUnexpectedException(Exception ex) {
    return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
        "Ocorreu um erro inesperado. Tente novamente mais tarde.");
  }

  private ResponseEntity<ErrorResponseDTO> errorResponse(HttpStatus status, String description) {
    ErrorResponseDTO response = new ErrorResponseDTO(status.value(), description, Instant.now());
    return ResponseEntity.status(status).body(response);
  }

}
