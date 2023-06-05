package com.br.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.br.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Rodrigo", 200.0, days);
	}
}
