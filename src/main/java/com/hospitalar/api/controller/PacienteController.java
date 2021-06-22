package com.hospitalar.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalar.api.model.Paciente;
import com.hospitalar.api.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

      @Autowired
      private PacienteService pacienteService;
      
      
      @PostMapping
      public ResponseEntity<Paciente> cadastraPaciente(@RequestBody Paciente paciente){
    	  
    	  Paciente cadastro = pacienteService.cadastrarPaciente(paciente);
    	  
    	  return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
      }
}
