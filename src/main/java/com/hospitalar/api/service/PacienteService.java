package com.hospitalar.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public List<Paciente> listarPacientes() {

		return pacienteRepository.findAll();
	}

	public Paciente listarPacientePorId(Long id) {

		return pacienteRepository.findById(id).get();
	}

	public Paciente updatePacientePorId(Paciente paciente, Long id) {

		Paciente updatePaciente = pacienteRepository.findById(id).get();

		if (updatePaciente != null) {

			BeanUtils.copyProperties(paciente, updatePaciente, "id");

			return updatePaciente = pacienteRepository.save(updatePaciente);
		}
		return updatePaciente;

	}
	
	public void deletarPacientePorId(Long id) {
		
		pacienteRepository.deleteById(id);
	}
	
	public Paciente consultaDinamicaDePaciente(String nome, String cpf, Integer idade, String dataNascimento, String telefone) {
		
		 List<Paciente> consultaDinamica = pacienteRepository.find(nome, cpf, idade, dataNascimento, telefone);
		 
		 if(consultaDinamica != null) {
			 
			 for (Paciente paciente : consultaDinamica) {
				return paciente;
			}
		 }
		 
		 throw new EmptyResultDataAccessException("Não encontrado", 0);
	}
}
