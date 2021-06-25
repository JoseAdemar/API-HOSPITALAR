package com.hospitalar.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrdemDeServico {
	
	 @Id
	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 
	 private String clinica;
	 
	
	 private String medico;
	 
	 
	 private String exame;
	 
	 
	 @OneToOne
	 private Paciente paciente;
	 
	 
	 @CreationTimestamp
	 private LocalDateTime dataHora;

}
