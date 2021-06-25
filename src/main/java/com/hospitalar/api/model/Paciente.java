package com.hospitalar.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "paciente")
public class Paciente {

	 @Id
	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 private String nome;
	 
	 @NotNull
	 private String cpf;
	 
	 
	 private Integer idade;
	 
	 
	 @Column(name = "data_de_nascimento")
	 private String dataNascimento;
	 
	 @NotNull
	 private String telefone;
	 
	 
}
