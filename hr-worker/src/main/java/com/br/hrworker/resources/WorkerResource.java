package com.br.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.hrworker.entities.Worker;
import com.br.hrworker.repositories.WorkerRepository;

//Api basica rodando pelo WebServices

@RestController  //recurso web para disponibilizar o endpoint
@RequestMapping(value = "/workers") //caminho padrao do recurso
public class WorkerResource {
	
	//endpoint para retornar todos os workers no banco
	
	@Autowired //injetando dependencia automaticamente
	private WorkerRepository repository;
	
	 //trazendo todos que estao no banco de dados
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> listWorker = repository.findAll();
		return ResponseEntity.ok(listWorker); 
	}
	
	 //trazendo pelo ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker workerId = repository.findById(id).get();
		return ResponseEntity.ok(workerId); 
	}

}
