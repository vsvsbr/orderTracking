package com.entrevistas.transports.orderTracking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entrevistas.transports.orderTracking.model.Order;
import com.entrevistas.transports.orderTracking.repository.OrderRepository;

@Controller
@RequestMapping("tracking")
public class TrackingController {
	
	@Autowired
	OrderRepository orderRepository;

	@GetMapping
	public String findOrderTracking(@RequestParam(name="orderId") String orderId, Model model) {

		try {
			Optional<Order> optional = orderRepository.findById(Long.valueOf(orderId));

			if (optional.isPresent()) {
				model.addAttribute("orderId", orderId);
				model.addAttribute("order", optional.get());
				return "tracking";
			}
		} catch (NumberFormatException e) {
			//TODO: extrair o parse
		}
		
		
		return "redirect:/";
		
	}

}
