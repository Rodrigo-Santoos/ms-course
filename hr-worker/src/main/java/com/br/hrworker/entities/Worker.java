package com.br.hrworker.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //monitorada pelo JPA
@Table(name = "tb_worker")//nome da tabela que vai criar no banco
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L; //Serializable serve para transforma a classe(objetos) em Bits
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //serve para o id gerar automaticamente no banco
	private Long id;
	private String name;
	private Double dailyIncome;
	
	//==================================================================================================
	//constructs
	public Worker() {	
	}

	public Worker(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	//==================================================================================================
	//getters e setters 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	//==================================================================================================
	//hashCode e equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(id, other.id);
	}
}
