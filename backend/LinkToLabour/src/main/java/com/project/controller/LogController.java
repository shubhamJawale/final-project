package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Role;
import com.project.pojos.User;
import com.project.service.AssignedWorkService;
import com.project.service.BiddingService;
import com.project.service.ContractorService;
import com.project.service.LabourService;
import com.project.service.ReviewService;
import com.project.service.UserService;
import com.project.service.WorkService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LogController {
	@Autowired
	UserService userService;
	@Autowired
	LabourService labourService;
	@Autowired
	ContractorService contractorService;
	@Autowired
	WorkService workService;
	@Autowired
	AssignedWorkService AssignedWorkService;
	@Autowired
	BiddingService biddingService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping(path = "/register", consumes = "application/json")
	public ResponseEntity<HttpStatus> registerUser(@RequestBody User user) {
		try {

			Role role = user.getRole();
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

			if (role == Role.LABOUR) {

				Labour labour = new Labour();
				this.userService.addUser(user);
				labour.setUser(user);
				this.labourService.addLabour(labour);

			} else if (role == Role.CONTRACTOR) {
				Contractor contractor = new Contractor();
				this.userService.addUser(user);
				contractor.setUser(user);
				this.contractorService.addContractor(contractor);
			} else {
				this.userService.addUser(user);
			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/login")
	public User login(@RequestBody User recieveduser) {
		User checkUser = this.userService.getUserByEmailId(recieveduser.getEmailId());
		String rpass = recieveduser.getPassword();
		String rEmail = recieveduser.getEmailId();
		//System.out.println(checkUser);
		
		String checkEmail = checkUser.getEmailId();
		String checkPass = checkUser.getPassword();
		System.out.println(rpass);
		boolean flag = bCryptPasswordEncoder.matches(rpass, checkUser.getPassword());
		System.out.println(flag);
		System.out.println(checkPass);
		if ( (rEmail.equals(checkEmail)) &&(flag) ) {
			User data = new User();
			System.out.println("method Invoked");
			
			data.setUserId(checkUser.getUserId());
			data.setUserName(checkUser.getUserName());
			data.setAddress(checkUser.getAddress());
			data.setEmailId(checkUser.getEmailId());
			data.setMobileNo(checkUser.getMobileNo());
			data.setPincode(checkUser.getPincode());
			data.setRole(checkUser.getRole());
			
			System.out.println(data);
			return data;
		} else {

			return null;
		}
	}

	
	
	@PostMapping(path ="/update", consumes = "application/json")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
		try {

			Role role = user.getRole();
			

		/*	if (role == Role.LABOUR) {
				this.userService.addUser(user);
				Labour labour = new Labour();
				labour.setUser(user);
				this.labourService.addLabour(labour);

			} else if (role == Role.CONTRACTOR) {
				this.userService.addUser(user);
				Contractor contractor = new Contractor();
				contractor.setUser(user);
				this.contractorService.addContractor(contractor);
			} else {*/
				this.userService.addUser(user);
			//}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
