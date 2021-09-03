package com.project.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.AssignedWork;
import com.project.pojos.Bidding;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Review;
import com.project.pojos.Role;
import com.project.pojos.Status;
import com.project.pojos.User;
import com.project.pojos.Work;
import com.project.pojos.WorkType;
import com.project.service.AssignedWorkService;
import com.project.service.BiddingService;
import com.project.service.ContractorService;
import com.project.service.LabourService;
import com.project.service.ReviewService;
import com.project.service.UserService;
import com.project.service.WorkService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contractor")

public class ContractorController {

	@Autowired
	UserService userService;
	@Autowired
	LabourService labourService;
	@Autowired
	ContractorService contractorService;
	@Autowired
	WorkService workService;
	@Autowired
	AssignedWorkService assignedWorkService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	BiddingService biddingService;

	// GetUSerdataForContractorId
	@GetMapping("/getdataBycontractorId/{contractorId}")
	public User getuserdatabyContractorId(@PathVariable int contractorId) {

		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);
		User user = contractor.getUser();
		// int userId = user.getUserId();
		return user; // this.userService.getUserById(userId);
	}

	// update professional details
	@PostMapping("/updatecontractorProfessionalDetails")
	public String UpdateContractor(@RequestBody Contractor contractor) {

		this.contractorService.addContractor(contractor);
		return "UpdatedSuccessFully!!";
	}

	// update personal details // or to add License no
	@PostMapping("/updateContractorPersonalDetails")
	public String updateContractorUser(@RequestBody User user) {
		this.userService.addUser(user);
		return "UpdatedSuccessFully!!";
	}

	// check null license nos
	@GetMapping("/checkLicenseNull/{contractorId}")
	public Boolean checkLicenseNo(@PathVariable int contractorId) {
		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);

		String licenseNo = contractor.getLicenceNo();

		if (licenseNo == null) {
			// TODO While devloping frontEnd Change this
			return false;
		} else {
			return true;
		}
	}

	// add labour/Register Lbaour
	@PostMapping("/AddLabourbyContractor/{contractorId}")
	public String addLabour(@RequestBody User user, @PathVariable int contractorId) {
		Labour labour = new Labour();
		//user.setRole(Role.LABOUR);
		this.userService.addUser(user);
		labour.setUser(user);
		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);
		labour.setContractor(contractor);
//		List<Labour> newList = contractor.getLabourList();
//		newList.add(labour);
		this.labourService.addLabour(labour);
		return "AddedSuccefully";
	}
	
	
	//AddBidding
	@PostMapping("/addbiddingbycontractor/{contractorId}/{workId}")
	public String addBiddingByContractor(@RequestBody Bidding bidding, @PathVariable int contractorId, @PathVariable int workId)
	{
		Work work =	this.workService.getWorkByWorkId(workId);
		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);
		bidding.setWork(work);
		bidding.setStatus(Status.PENDING);
		//this will return only contracotr just name is changed
		bidding.setContractorList(contractor);
		this.biddingService.AddBidding(bidding);
		return "Added Succefully";	
	}
	
	
	//get Reviews By Contractor ID
	@GetMapping("/getreviewbycontractorid/{contractorId}")
	public List<Review> getReviewsByContractorId(@PathVariable int contractorId)
	{
		return this.reviewService.getReviewsByContractorId(contractorId);
	}
	
	//get all work by pincode only
	@GetMapping("/getworkbypincode/{pincode}")
	public List<Work> getAllWorkByPincode(@PathVariable String pincode)
	{
		return this.workService.getWorkByPincode(pincode);
	}
	
	//this could be usefull in labour also and user if required
	//get work by pincode status and worktype
	//this is the main method to get all works for contractors
	@GetMapping("/getworkbyworktype/{contractorId}")
	public List<Work> getWorkByWorkType(@PathVariable int contractorId)
	{
		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);
		User user = contractor.getUser();
		String pincode = user.getPincode();
		WorkType type = WorkType.CWORK;
		LocalDate now = LocalDate.now();
		Status status = Status.PENDING;
		return this.workService.getAllWorkByWorkType(now, pincode, type, status);
	}
	
	
	
	//getAssignedWork By Contractor Id
	@GetMapping("/getallworkbycontractorid/{contractorId}")
	public List<AssignedWork> getAllContractorId(@PathVariable int contractorId)
	{
		return this.assignedWorkService.getAssignedWorkByContractorsId(contractorId);
	}
	
	
	//delete labour from team 
	@GetMapping("/deletelabourfromteam/{LabourId}")
	public String DeleteLabourFromTeam(@PathVariable int LabourId)
	{
		Labour  labour = this.labourService.getLabourById(LabourId);
		labour.setContractor(null);
		this.labourService.addLabour(labour);
		return "Deleted succesfull";
	}
	

}
