package com.hospitalar.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hospitalar.api.model.OrdemDeServico;
import com.hospitalar.api.model.Paciente;
import com.hospitalar.api.repository.OrdemDeServicoRepository;

@Service
public class OrdemDeServicoService {

	 @Autowired
	 private OrdemDeServicoRepository ordemDeServicoRepository;
	 
	 public OrdemDeServico cadastrarOs(OrdemDeServico ordemDeServico) {
		 
		   return ordemDeServicoRepository.save(ordemDeServico);
	 }
	 
	 public List<OrdemDeServico> listarTodasAsOrdemDeServico(){
		 
		 return ordemDeServicoRepository.findAll();
	 }
	 
	 public OrdemDeServico listarOrdemDeServicoPorId(Long id) {
		 
		 return ordemDeServicoRepository.findById(id).get();
	 }
	 
	 public OrdemDeServico updateOrdemDeServicoPorId(OrdemDeServico ordemDeServico, Long id) {
		 
		 OrdemDeServico updatePorId = ordemDeServicoRepository.findById(id).get();
		 
		 if(updatePorId != null) {
			 
			 BeanUtils.copyProperties(ordemDeServico, updatePorId, "id", "dataHora");
			 
			 updatePorId = ordemDeServicoRepository.save(updatePorId);
		 }
		return updatePorId;
	 }
	 
	 public void deletarOrdemDeServicoPorId(Long id) {
		 
		 ordemDeServicoRepository.deleteById(id);
	 }
	 
	 public OrdemDeServico consultaDinamicaOrdemDeServico(String clinica, String medico, String exame, Paciente paciente) {
		 
		    List<OrdemDeServico> buscaDinamica = ordemDeServicoRepository.find(clinica, medico, exame, paciente);
		    
		    if(buscaDinamica != null) {
		    	
		    	for (OrdemDeServico ordemDeServico : buscaDinamica) {
					return ordemDeServico;
				}
		    }
		    
		    throw new EmptyResultDataAccessException("Dados não encontrados", 0);
	 }
}
