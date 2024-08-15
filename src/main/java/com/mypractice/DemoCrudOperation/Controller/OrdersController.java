package com.mypractice.DemoCrudOperation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.DemoCrudOperation.Dto.OrderPaymentsDto;
import com.mypractice.DemoCrudOperation.Service.OrderPaymentsService;

@RestController
@RequestMapping("/api")
public class OrdersController {
	
	@Autowired
	private OrderPaymentsService orderPaymentsService;

	@PostMapping("/saveOrder")
	public OrderPaymentsDto saveOrder(@RequestBody OrderPaymentsDto orderPaymentsDto) {
		return orderPaymentsService.payment(orderPaymentsDto);
	}
}
