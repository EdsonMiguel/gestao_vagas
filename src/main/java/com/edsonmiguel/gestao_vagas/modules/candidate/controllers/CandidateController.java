package com.edsonmiguel.gestao_vagas.modules.candidate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsonmiguel.gestao_vagas.modules.candidate.CandidateEntity;
import com.edsonmiguel.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateController {

  private CreateCandidateUseCase createCandidateUseCase;

  @PostMapping
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
    try {
      var result = this.createCandidateUseCase.execute(candidate);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }
}
