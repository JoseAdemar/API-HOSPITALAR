package com.hospitalar.api.repository;

import java.util.List;

import com.hospitalar.api.model.Paciente;

public interface PacienteRepositoryQueries {

	 List<Paciente> find(String nome, String cpf, Integer idade, String dataNascimento, String telefone);
}
