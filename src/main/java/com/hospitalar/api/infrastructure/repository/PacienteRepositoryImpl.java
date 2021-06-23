package com.hospitalar.api.infrastructure.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.hospitalar.api.model.Paciente;
import com.hospitalar.api.repository.PacienteRepositoryQueries;

@Repository
public class PacienteRepositoryImpl implements PacienteRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Paciente> find(String nome, String cpf, Integer idade, String dataNascimento, String telefone) {
		
		var jpql = new StringBuilder();
		jpql.append("from Paciente where 0 = 0 ");
		
		var parametros = new HashMap<String, Object>();

		if (StringUtils.hasLength(nome)) {

			jpql.append("and nome like :nome ");
			parametros.put("nome", "%" + nome + "%");
		}
		
		if (cpf != null) {

			jpql.append("and cpf = :cpf ");
			parametros.put("cpf", cpf);
		}

		if (idade != null) {

			jpql.append("and idade = :idade ");
			parametros.put("idade", idade);
		}

		if (dataNascimento != null) {

			jpql.append("and dataNascimento = :dataNascimento ");
			parametros.put("dataNascimento", dataNascimento);
		}
		
		if (telefone != null) {

			jpql.append("and telefone = :telefone ");
			parametros.put("telefone", telefone);
		}

		TypedQuery<Paciente> query = manager.createQuery(jpql.toString(), Paciente.class);

				parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
				return query.getResultList();

	}

}