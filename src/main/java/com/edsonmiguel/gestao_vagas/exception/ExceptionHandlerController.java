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

import com.edsonmiguel.gestao_vagas.module.candidate.exception.CandidateAlreadyExistsException;
import com.edsonmiguel.gestao_vagas.module.company.exception.CompanyAlreadyExistsException;

@RestControllerAdvice
public class ExceptionHandlerController {

  private MessageSource messageSource;

  public ExceptionHandlerController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    String description = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getField() + ": "
            + messageSource.getMessage(error, LocaleContextHolder.getLocale()))
        .collect(Collectors.joining("; ", "Revise os campos informados: ", ""));

    return errorResponse(HttpStatus.BAD_REQUEST, description);
  }

  @ExceptionHandler({ CandidateAlreadyExistsException.class, CompanyAlreadyExistsException.class })
  public ResponseEntity<ErrorResponseDTO> handleAlreadyExistsException(RuntimeException ex) {
    return errorResponse(HttpStatus.CONFLICT, ex.getMessage());
  }

  private ResponseEntity<ErrorResponseDTO> errorResponse(HttpStatus status, String description) {
    ErrorResponseDTO response = new ErrorResponseDTO(status.value(), description, Instant.now());
    return ResponseEntity.status(status).body(response);
  }

}
