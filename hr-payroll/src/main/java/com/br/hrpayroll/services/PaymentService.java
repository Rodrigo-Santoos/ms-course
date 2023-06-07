package com.br.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.hrpayroll.entities.Payment;
import com.br.hrpayroll.entities.Worker;
import com.br.hrpayroll.feighclients.WorkerFeignClient;

@Service
public class PaymentService {

	//como esta usando a interface WorkerFeignClient nao precisa desses valores
	
	/*@Value("${hr-worker.host}") //pegando da propriedade criada no application.properties
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;*/
	
	//----------------------------------------------------------------------------------
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		//codigo do restTemplate
		/*Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id",""+workerId);
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);*/
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	
}
