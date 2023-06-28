package com.cg.controller;

import java.util.Arrays;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.client.RestTemplate;

import com.cg.models.Admin;
import com.cg.models.OrderDetails;
import com.cg.models.Payment;
import com.cg.models.UserDetail;
import com.cg.models.UserRating;
import com.cg.models.Washers;
import com.cg.models.Washpack;
import com.cg.services.AdminService;
import com.cg.services.LoginService;

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
@RequestMapping("/admin")
public class AdminController 
{
    
    
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	 
	@Autowired
	private AdminService service;
	
	@Autowired
	private LoginService admin;
	
	
    @Autowired
	private RestTemplate restTemplate;
    //Admin operations
    @PostMapping("/addadmin")
    @ApiOperation(value="To Add admin Details")
    public String saveAdmin(@RequestBody Admin admin)
    {
    	logger.info("Adding Admin");
    	service.saveAdmin(admin);
		return "Registration Succefully!!!";
    }
    @PutMapping("account/update")
    @ApiOperation(value="To update admin details")
    public String updateAdmin(@RequestBody Admin admin) {
    	logger.info("Updating the admin details");
    	service.updateAdmin(admin);
        return "Updated succesfully";
}
    
    @GetMapping("/alladmins")
	@ApiOperation(value = "To Get all Admins Details")
	public List<Admin> findAll() {
    logger.info("Getting all admins");
	return service.findAll();
		
	}
    @DeleteMapping("/account/delete")
	@ApiOperation(value = "To delete admin Details")
    public ResponseEntity<Object> deleteadmin(@RequestParam int id) {
    	logger.info("Deleting the  admin account");
		service.deleteAdmin(id);
		return new ResponseEntity<Object>("Admin deleted with id " + id, HttpStatus.OK);
	 
	 }

	
    
    //Washpack operations
    @PostMapping("/addwashpack")
	@ApiOperation(value = "To Add washpack Details")
	public String saveWashpack(@RequestBody Washpack washpacks) {
    	logger.info("Adding washpacks");
		 service.saveWashpack(washpacks);
		 return "WashPack Added Succesfully!!!";
	}
    @PutMapping("/washpack/update")
	@ApiOperation(value = "To update washpack Details")
	public String updateWashpack(@RequestBody Washpack updatepack ) {
    	logger.info("Updating washpack details");
		service.updateWashpack(updatepack);
		return "Washpack updated Succesfull!!!";

	}
    @GetMapping("/washpack")
	@ApiOperation(value = "To get washpack Details")
	public List<Washpack> findAll1(){
    	logger.info("Getting List Of washpacks");
		return service.getWashpack();

}
	@DeleteMapping("/deletepack")
	@ApiOperation(value = "To delete washpack Details")
	public String deletewashpack(@RequestParam int id ) {
		logger.info("Deleting washpacks");
	 service.deleteWashpack(id);
	 return "Washpack Deleted Succesfully!!!";

	}
//	@PostMapping("/deletepack/{id}")
//	public ResponseEntity<String> deletepack(@PathVariable("id") int id) {
//		service.deleteWashpack(id);
//		return new ResponseEntity<>("WashPack is Deleted", HttpStatus.OK);
//	}
//	
	
//	@GetMapping("/viewPack/{id}")
//	public String viewPack(@PathVariable int id)  {
//
//		Washpack pack = service.viewPack(id);
//		
//		return  pack;
//	}
	
	@GetMapping("/viewPack/{Id}")
	public ResponseEntity<Washpack> viewPack(@PathVariable int Id) 
	{
			Washpack pack =service.viewPack(Id);
			logger.info("Viewing Pack");
			return new ResponseEntity<Washpack>(pack,HttpStatus.OK);
	}
	
	
       //Rating 

	
	@PostMapping("/login")

	public String adminLogin(@RequestBody Admin login) {
		logger.info("Admin login");
		return admin.adminLogin(login);
	}
    //Rest template
	
	@GetMapping("/allorders")
	public List<OrderDetails> getallOrders(){
		 String baseurl="http://localhost:9092/order/allorders";
		 OrderDetails[] orders=restTemplate.getForObject(baseurl, OrderDetails[].class);
		return Arrays.asList(orders);
		
	}
	
	@GetMapping("/allpayment")
		public List<Payment> getallpayment(){
			 String baseurl="http://localhost:9093/payment/all";
			 Payment[] pay=restTemplate.getForObject(baseurl, Payment[].class);
			return Arrays.asList(pay);
}
		
	@GetMapping("/allusers")
			public List<UserDetail> getallusers(){
				 String baseurl="http://localhost:9093/user/allusers";
				 UserDetail[] user =restTemplate.getForObject(baseurl, UserDetail[].class);
				return Arrays.asList(user);
			
}
	@GetMapping("/allwasher")
			public List<Washers> getwasher(){
				 String baseurl="http://localhost:9094/washer/allwasher";
				 Washers[] washer =restTemplate.getForObject(baseurl, Washers[].class);
				return Arrays.asList(washer);
			
			
			}
}
