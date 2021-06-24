package com.hospitalar.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
	 
	 @NotNull
	 private String clinica;
	 
	 @NotNull
	 private String medico;
	 
	 @NotNull
	 private String exame;
	 
	 @NotNull
	 @OneToOne
	 private Paciente paciente;
	 
	 
	 @CreationTimestamp
	 private LocalDateTime dataHora;

}
