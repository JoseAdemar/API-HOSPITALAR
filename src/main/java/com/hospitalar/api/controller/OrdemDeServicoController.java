package com.hospitalar.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.hospitalar.api.model.OrdemDeServico;
import com.hospitalar.api.model.Paciente;
import com.hospitalar.api.service.OrdemDeServicoService;

@RestController
@RequestMapping("/ordem-os")
public class OrdemDeServicoController {

	 @Autowired
     private OrdemDeServicoService ordemDeServicoService;
     
     
     @PostMapping
     public ResponseEntity<OrdemDeServico> cadastraOs(@RequestBody @Valid OrdemDeServico ordemDeServico){
   	  
   	  OrdemDeServico cadastro = ordemDeServicoService.cadastrarOs(ordemDeServico);
   	  
   	  return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
     }
     
     @GetMapping
     public ResponseEntity<List<OrdemDeServico>> listaOrdemDeServico(){
    	 
    	 List<OrdemDeServico> listaOrdens = ordemDeServicoService.listarTodasAsOrdemDeServico();
    	 return ResponseEntity.status(HttpStatus.OK).body(listaOrdens);
     }
     
     @GetMapping("/{id}")
     public ResponseEntity<OrdemDeServico> listaOrdemDeServicoPorId(@PathVariable Long id){
    	 
    	 OrdemDeServico listaPorId = ordemDeServicoService.listarOrdemDeServicoPorId(id);
    	 
    	 return ResponseEntity.status(HttpStatus.OK).body(listaPorId);
     }
     
     
     @PutMapping("/{id}")
     public ResponseEntity<OrdemDeServico> updateOrdemDeServicoPorId(@RequestBody @Valid OrdemDeServico ordemDeServico , @PathVariable Long id){
    	 
    	 OrdemDeServico listaPorId = ordemDeServicoService.updateOrdemDeServicoPorId(ordemDeServico, id);
    	 
    	 return ResponseEntity.status(HttpStatus.OK).body(listaPorId);
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<OrdemDeServico> deletaOrdemDeServicoPorId(@PathVariable Long id){
    	 
    	 ordemDeServicoService.deletarOrdemDeServicoPorId(id);
    	 
    	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }
     
     @GetMapping("/os-busca")
     public ResponseEntity<?> consultaDinamicaOrdemDeServico(String clinica, String medico, String exame, Paciente paciente){
    	 
    	 OrdemDeServico buscaDinamica = ordemDeServicoService.consultaDinamicaOrdemDeServico(clinica, medico, exame, paciente);
    	 
    	 return ResponseEntity.status(HttpStatus.OK).body(buscaDinamica);
    	 
     }
}
