package com.hospitalar.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalar.api.model.Paciente;
import com.hospitalar.api.repository.PacienteRepository;

@Service
public class PacienteService {

	 @Autowired
	 private PacienteRepository pacienteRepository;
	 
	 public Paciente cadastrarPaciente(Paciente paciente) {
		 
		   return pacienteRepository.save(paciente);
	 }
}
