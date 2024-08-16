package com.mypractice.DemoCrudOperation.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.DemoCrudOperation.Dto.OrderPaymentsDto;
import com.mypractice.DemoCrudOperation.Dto.PaymentsDto;
import com.mypractice.DemoCrudOperation.Entity.Orders;
import com.mypractice.DemoCrudOperation.Entity.Payments;
import com.mypractice.DemoCrudOperation.Exception.InvalidPaymentException;
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
	
	@Transactional
	public OrderPaymentsDto payment(OrderPaymentsDto orderPaymentsDto) {
	    Orders orders = new Orders();
	    orders.setStatus(orderPaymentsDto.getStatus());
	    orders.setMessage(orderPaymentsDto.getMessage());
	    orders.setOrderTrackingNumber(UUID.randomUUID().toString());

	    PaymentsDto paymentsDto = orderPaymentsDto.getPayments();
        if (paymentsDto == null || paymentsDto.getPayment() == 0) {
            throw new InvalidPaymentException("Payment amount must be greater than 0.");
        }
	    
	    Payments payments = new Payments();
	    payments.setPayment(paymentsDto.getPayment());
	    payments.setMode(paymentsDto.getMode());

//	    Saving payments in PaymentsRepository
//	    -------------------------------------
	    orders.setPayments(payments);
	    paymentsRepository.save(payments);
	    
//	    Saving order in OrdersRepository
//	    --------------------------------
	    Orders savedOrder = ordersRepository.save(orders);
	    
	    orderPaymentsDto.setOrderno(savedOrder.getOrderno());
	    orderPaymentsDto.setOrderTrackingNumber(savedOrder.getOrderTrackingNumber());

	    return orderPaymentsDto;
	}

}
