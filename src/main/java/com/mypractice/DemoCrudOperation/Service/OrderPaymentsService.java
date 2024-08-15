package com.mypractice.DemoCrudOperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.DemoCrudOperation.Dto.OrderPaymentsDto;
import com.mypractice.DemoCrudOperation.Entity.Orders;
import com.mypractice.DemoCrudOperation.Entity.Payments;
import com.mypractice.DemoCrudOperation.Repository.OrdersRepository;
import com.mypractice.DemoCrudOperation.Repository.PaymentsRepository;

@Service
public class OrderPaymentsService {
	
	private OrdersRepository ordersRepository;
	private PaymentsRepository paymentsRepository;
	
	@Autowired
	public OrderPaymentsService(OrdersRepository ordersRepository, PaymentsRepository paymentsRepository) {
		super();
		this.ordersRepository = ordersRepository;
		this.paymentsRepository = paymentsRepository;
	}
	
	public OrderPaymentsDto payment(OrderPaymentsDto orderPaymentsDto) {
		Orders orders = new Orders();
		orders.setStatus(orderPaymentsDto.getStatus());
		orders.setMessage(orderPaymentsDto.getMessage());
		
		Payments payments = new Payments();
		payments.setPayment(orderPaymentsDto.getPayment());
		payments.setMode(orderPaymentsDto.getMode());
		
		ordersRepository.save(orders);
		return null;
	}
}
