package com.br.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	
	//testando o ribbon
	@Autowired
	private Environment env;

	//imprimir coisas no logger da aplicaçao
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class); // pegando a classe que quer fazer logger
	
	@Autowired //injetando dependencia automaticamente
	private WorkerRepository repository;
	
	 //trazendo todos que estao no banco de dados
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> listWorkers = repository.findAll();
		return ResponseEntity.ok(listWorkers); 
	}
	
	 //trazendo pelo ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		//imprimindo no console qual a porta que esta rodando com Environment
		logger.info("Port = " + env.getProperty("local.server.port"));
		
		Worker workerId = repository.findById(id).get();
		return ResponseEntity.ok(workerId); 
	}

}
