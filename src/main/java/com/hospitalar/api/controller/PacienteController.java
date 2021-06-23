package com.hospitalar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Paciente> cadastraPaciente(@RequestBody Paciente paciente) {

		Paciente cadastro = pacienteService.cadastrarPaciente(paciente);

		return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
	}

	@GetMapping
	public ResponseEntity<List<Paciente>> listaTodosPacientes() {

		List<Paciente> listaPacientes = pacienteService.listarPacientes();
		
		return ResponseEntity.status(HttpStatus.OK).body(listaPacientes);

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listaTodosPacientesPorId(@PathVariable Long id) {

		Paciente listaPorId = pacienteService.listarPacientePorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaPorId);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> atualizaPacientesPorId(@RequestBody Paciente paciente, @PathVariable Long id) {

		Paciente listaPorId = pacienteService.updatePacientePorId(paciente, id);
		
		return ResponseEntity.status(HttpStatus.OK).body(listaPorId);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> deletaPacientesPorId(@PathVariable Long id) {

		    pacienteService.deletarPacientePorId(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
	
	@GetMapping("/consultas-dinamicas")
	public ResponseEntity<?> consultaDinamicaPacientes(String nome, String cpf, Integer idade, String dataNascimento, String telefone){
		
		  Paciente buscaDinamica = pacienteService.consultaDinamicaDePaciente(nome, cpf, idade, dataNascimento, telefone);
		  
		  return ResponseEntity.status(HttpStatus.OK).body(buscaDinamica);
	}
}
