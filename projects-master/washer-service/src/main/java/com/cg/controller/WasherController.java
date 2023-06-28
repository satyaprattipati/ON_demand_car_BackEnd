package com.cg.controller;

import java.util.Arrays;
//import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.catalina.User;
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
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

import com.cg.models.OrderDetails;

import com.cg.models.WasherLogin;
//import com.cg.models.OrderDetails;
//import com.cg.models.UserRating;
import com.cg.models.Washers;
import com.cg.services.LoginService;
import com.cg.services.WasherService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/washer")

/* Name:Siva Kumar Bevara
 * EmpId: 46195757
 * Creation Date:22/07/22
 * Modification Date:23/07/22
 * 
 */
public class WasherController
{
   
    
	Logger logger = LoggerFactory.getLogger(WasherController.class);
	 @Autowired
		private WasherService service;
	 
	 @Autowired
		private RestTemplate restTemplate;
	 
	 @Autowired
		private LoginService washer;
    
    @PostMapping("/addwasher")
    @ApiOperation(value = "To Add washer Details")
    public String saveUser(@RequestBody Washers washer) {
    	logger.info("Adding washer"); 
    	 service.save(washer);
    	 return "you Are working With GreenWash Carwash";
    }

    @PutMapping("/account/update")
    @ApiOperation(value = "To Update washer Details")
    public String updateRegistrationDetails(@RequestBody Washers user) {
    	logger.info("Updating registration details"); 
    	 service.save(user);
    	 return "update of details Successfull";

    }

	@GetMapping("/viewWasher/{Id}")
	public ResponseEntity<Washers> viewWasher(@PathVariable int Id) 
	{
			Washers washer =service.viewWasher(Id);
			logger.info("view details"); 
			return new ResponseEntity<Washers>(washer,HttpStatus.OK);
	}

    @GetMapping("/allwasher")
    @ApiOperation(value = "To Get all washer Details")
    public List<Washers> findAll(){
    	logger.info("Getting all washers");
    	return service.getWashers();
    }

//    @DeleteMapping("/account/delete")
//    @ApiOperation(value = "To delete washer ")
//    public String deletewasher( @RequestParam int id ) {
//    	 logger.info("Deleting washer"); 
//    	 this.service.deleteWasher(id);
//    	 return "Account Delete Happy to work With you";
//    }
    @DeleteMapping("/account/delete")
	public ResponseEntity<String> deletewasher(@RequestParam int id ) {
		ResponseEntity<String> responseEntity = null;
	     service.deleteWasher(id);
		responseEntity = new ResponseEntity<>("washer deleted successfully", HttpStatus.OK);
		 logger.info("Deleting washer"); 
		return responseEntity;
	}


    @PostMapping("/login")
	@ApiOperation(value = "To Add Login Details")
	public String userWasher(@RequestBody WasherLogin login) {
    	logger.info("Adding login details for user");
		return washer.Washer(login);
	}
    /*------------------ Resttemplates---------------------------- */
    
	
	
        
		
		@GetMapping("/allorders")

		public List<OrderDetails> getallorders() {
			String baseurl = "http://localhost:9092/order/allorders";
			OrderDetails[] allorders = restTemplate.getForObject(baseurl, OrderDetails[].class);

			return Arrays.asList(allorders);

		}
}
