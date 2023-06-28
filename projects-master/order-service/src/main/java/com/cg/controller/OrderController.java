package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Name:Siva Kumar Bevara
 * EmpId: 46195757
 * Creation Date:22/07/22
 * Modification Date:23/07/22
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.ApiRequestException;
import com.cg.models.OrderDetails;
import com.cg.repository.OrderRepo;
import com.cg.services.OrderService;

import io.swagger.annotations.ApiOperation;
/* Name:Siva Kumar Bevara
 * EmpId: 46195757
 * Creation Date:22/07/22
 * Modification Date:23/07/22
 * 
 */
//@CrossOrigin(origins = "http://localhost:3000/")
@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private OrderService orderservice;
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);

	

	@PostMapping("/addorder")
	@ApiOperation(value = "To Add new order")
	public String addOrder(@RequestBody OrderDetails order) {
		logger.info("Adding Order");
		order.setOrderId(orderservice.getSequenceNumber(OrderDetails.SEQUENCE_NAME));
		orderservice.addOrder(order);
		return "order placed with washer" + order;
	}

	@GetMapping("/allorders")
	@ApiOperation(value = "To Get all order Details")
	public List<OrderDetails> orderDetails() {
		logger.info("Fetching all Orders");
		return orderservice.orderDetails();
	}

	@PutMapping("/updateorder")
	@ApiOperation(value = "To update order Details")
	public String updateOrder( @RequestBody OrderDetails update) {
		logger.info("Updating Order Details");
		orderservice.updateOrder(update);
		return "Updated sucessfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("id") int id) {
		ResponseEntity<String> responseEntity = null;
		orderservice.deleteById(id);
		responseEntity = new ResponseEntity<>("order deleted successfully", HttpStatus.OK);
		logger.info("Deleted order successfully");
		return responseEntity;
	}
	@GetMapping("/viewOrder/{Id}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable int Id) 
	{
			OrderDetails order =orderservice.viewOrder(Id);
			 logger.info("Successfully got all order by id");  
			return new ResponseEntity<OrderDetails>(order,HttpStatus.OK);
	}
	@GetMapping("/viewOrderByUsername/{username}")

	public List<OrderDetails> findorderByUserName(@PathVariable String username) {
		return orderservice.getorderbyusername(username);
	}


}

