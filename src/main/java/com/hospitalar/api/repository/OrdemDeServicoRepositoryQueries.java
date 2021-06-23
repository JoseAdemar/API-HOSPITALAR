package com.hospitalar.api.repository;

import java.util.List;

import com.hospitalar.api.model.OrdemDeServico;
import com.hospitalar.api.model.Paciente;

public interface OrdemDeServicoRepositoryQueries {

	 List<OrdemDeServico> find(String clinica, String medico, String exame, Paciente paciente);
}
