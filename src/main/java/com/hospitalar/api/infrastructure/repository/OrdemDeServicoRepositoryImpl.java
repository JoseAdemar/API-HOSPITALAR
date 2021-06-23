package com.hospitalar.api.infrastructure.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.hospitalar.api.model.OrdemDeServico;
import com.hospitalar.api.model.Paciente;
import com.hospitalar.api.repository.OrdemDeServicoRepositoryQueries;

@Repository
public class OrdemDeServicoRepositoryImpl implements OrdemDeServicoRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<OrdemDeServico> find(String clinica, String medico, String exame, Paciente paciente) {
		
		var jpql = new StringBuilder();
		jpql.append("from OrdemDeServico where 0 = 0 ");
		
		var parametros = new HashMap<String, Object>();
		
		if (StringUtils.hasLength(clinica)) {
			jpql.append("and clinica like :clinica ");
			parametros.put("clinica", "%" + clinica + "%");
		}
		
		if (medico != null) {
			jpql.append("and medico like :medico ");
			parametros.put("medico", "%" + medico + "%");
		}
		
		if (exame != null) {
			jpql.append("and exame like :exame ");
			parametros.put("exame", "%" + exame + "%");
		}
		
		
		if (paciente.getCpf() != null) {
			jpql.append("and paciente.cpf = :pacienteCpf ");
			parametros.put("pacienteCpf",  paciente.getCpf() );
		}
		
		
		TypedQuery<OrdemDeServico> query = manager
				.createQuery(jpql.toString(), OrdemDeServico.class);
		
		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

		return query.getResultList();
		
		
	}

}