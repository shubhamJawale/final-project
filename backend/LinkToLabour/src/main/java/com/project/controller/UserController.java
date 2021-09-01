package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Role;
import com.project.pojos.User;
import com.project.service.ContractorService;
import com.project.service.LabourService;
import com.project.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	LabourService labourService;
	@Autowired
	ContractorService contractorService;
	
	@PostMapping(path="/register", consumes="application/json")
	public ResponseEntity<HttpStatus> registerUser(@RequestBody User user) 
	{
		try {
			
			Role role = user.getRole();
			
			
			
			if(role == Role.LABOUR)
			{
				
				Labour labour = new Labour() ;
				this.userService.addUser(user);
				labour.setUser(user);
				this.labourService.addLabour(labour);
				
			}
			else if(role == Role.CONTRACTOR)
			{
				Contractor contractor = new Contractor();
				this.userService.addUser(user);
				contractor.setUser(user);
				this.contractorService.addContractor(contractor);
			}else
			{
				this.userService.addUser(user);
			}
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	
	}
	
	
	
}
