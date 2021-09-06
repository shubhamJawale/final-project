package com.project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AssignedWorkDto;
import com.project.dto.LabourUserContractorDto;
import com.project.pojos.AssignedWork;
import com.project.pojos.Bidding;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Requests;
import com.project.pojos.Review;
import com.project.pojos.Status;
import com.project.pojos.User;
import com.project.pojos.Work;
import com.project.pojos.WorkType;
import com.project.service.AssignedWorkService;
import com.project.service.BiddingService;
import com.project.service.ContractorService;
import com.project.service.LabourService;
import com.project.service.RequestService;
import com.project.service.ReviewService;
import com.project.service.UserService;
import com.project.service.WorkService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/labour")
public class LabourController {
	@Autowired
	BiddingService biddingService;
	@Autowired
	UserService userService;
	@Autowired
	ContractorService contractorService;
	@Autowired
	LabourService labourService;
	@Autowired
	WorkService workService;
	@Autowired
	AssignedWorkService assignedWorkService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	RequestService requestService;

	// AddBidding
	@PostMapping("/addbidiingbylabour/{labourId}/{workId}")
	public Work AddBiidingByLabour(@RequestBody Bidding bidding, @PathVariable int labourId, @PathVariable int workId) {
		Labour labour = this.labourService.getLabourById(labourId);
		Work work = this.workService.getWorkByWorkId(workId);
		bidding.setLabour(labour);
		bidding.setWork(this.workService.getWorkByWorkId(workId));
		bidding.setStatus(Status.PENDING);
		this.biddingService.AddBidding(bidding);
		return work; // "bidding added successfully";

	}

	// get review by labour id
	@GetMapping("/getallreviewbylabourId/{labourId}")
	public List<Review> getAllReviewsbyReviewId(@PathVariable int labourId) {
		return this.reviewService.getReviewsByLabourId(labourId);
	}

	// getReviewByContractorId
	@GetMapping("/getallreviewbycontractorid/{contractorId}")
	public List<Review> getAllreviewByContractorId(@PathVariable int contractorId) {
		return this.reviewService.getReviewsByContractorId(contractorId);
	}

	// getWork BY PINCODE STATUS EXCEEDED DATE WORKTYPe
	@GetMapping("/getworkbyworktype/{labourId}")
	public List<Work> getWorkByWorkType(@PathVariable int labourId) {
		Labour labour = this.labourService.getLabourById(labourId);
		User user = labour.getUser();
		String pincode = user.getPincode();
		WorkType type = WorkType.LWORK;
		LocalDate now = LocalDate.now();
		Status status = Status.PENDING;
		return this.workService.getAllWorkByWorkType(now, pincode, type, status);
	}

	/*
	 * // getAssignedWork By Contractor Id
	 * 
	 * @GetMapping("/getallworkbycontractorid/{labourId}") public List<AssignedWork>
	 * getAllContractorId(@PathVariable int labourId) { Labour labour =
	 * this.labourService.getLabourById(labourId); Contractor contractor =
	 * labour.getContractor(); int contractorId = contractor.getContractorId();
	 * return this.assignedWorkService.getAssignedWorkByContractorsId(contractorId);
	 * }
	 */

	// getallAssignedWorkForTeamand also for individual labour
	@GetMapping("/getAssignedWorkforteam/{labourId}")
	public List<AssignedWork> getAllAssignedWorkOfTeam(@PathVariable int labourId) {
		Labour labour = this.labourService.getLabourById(labourId);

		if (labour.getContractor() != null) {
			Contractor contractor = labour.getContractor();
			int id = contractor.getContractorId();
			return this.assignedWorkService.getAssignedWorkByContractorsId(id);
		} else {
			return this.assignedWorkService.getAssignedWorkByLabourId(labourId);
		}
	}

	// get all contractor list by pincode
	@GetMapping("/getallcontractorsbypincode/{labourId}")
	public List<Contractor> getallContractorsByPincode(@PathVariable int labourId) {
		Labour labour = this.labourService.getLabourById(labourId);
		User user = labour.getUser();
		String pin = user.getPincode();

		return this.contractorService.getAllcContractorByPincode(pin);
	}

	// send request to contractor
	@PostMapping("/sendRequest/{labourId}/{contractorId}")
	public ResponseEntity<HttpStatus> sendRequestToContractor(@PathVariable int labourId,
			@PathVariable int contractorId, @RequestBody Requests requests) {
		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);
		Labour labour = this.labourService.getLabourById(labourId);
		Contractor check = labour.getContractor();
		if (contractor != check) {
			requests.setContractor(contractor);
			requests.setLabour(labour);
			this.requestService.addRequest(requests);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//getLabourRequestList
	
	@GetMapping("/getAllRequestByLabourid/{labourId}")
	public List<Requests> getAllrequestByLabourId(@PathVariable int labourId)
	{
		return this.requestService.getAllRequestsByLabourId(labourId);
	}
	
//==========================================================================================
	@GetMapping("/getalldata/AssignedWork/{labourId}")
	public List<AssignedWorkDto> getalldataAssignedWorkById(@PathVariable int labourId)
	{
		
		List<AssignedWork> aw =this.assignedWorkService.getAssignedWorkByLabourId(labourId);
		List<AssignedWorkDto> asw = new ArrayList<AssignedWorkDto>();
		ListIterator<AssignedWork> pt1 = aw.listIterator();
		while(pt1.hasNext())
		{
			AssignedWork aw1 = (AssignedWork)pt1.next();
			AssignedWorkDto asw1 = new AssignedWorkDto();
			asw1.setAssignedWorkId(aw1.getAssignedWorkId());
			asw1.setAstatus(aw1.getStatus());
			asw1.setBiddingId(aw1.getBidding().getBiddingId());
			asw1.setBamount(aw1.getBidding().getAmount());
			asw1.setBdescription(aw1.getBidding().getDescription());
			asw1.setBfromDate(aw1.getBidding().getFromDate());
			asw1.setBtoDate(aw1.getBidding().getToDate());
			if(aw1.getBidding().getContractor()!=null) {
			asw1.setContractorId(aw1.getBidding().getContractor().getContractorId());}
			if(aw1.getBidding().getLabour()!=null) {
			asw1.setLabourId(aw1.getBidding().getLabour().getLabourId());}
			asw1.setDescription(aw1.getWork().getDescription());
			asw1.setExpectedAmount(aw1.getWork().getExpectedAmount());
			asw1.setFromDate(aw1.getWork().getFromDate());
			asw1.setPinCode(aw1.getWork().getPinCode());
			asw1.setToDate(aw1.getWork().getToDate());
			asw1.setTitle(aw1.getWork().getTitle());
			asw1.setWorkType(aw1.getWork().getWorkType());
			asw1.setWorkId(aw1.getWork().getWorkId());
			asw1.setWorkType(aw1.getWork().getWorkType());
			asw1.setWstatus(aw1.getWork().getStatus());
			asw1.setUid(aw1.getWork().getUser().getUserId());
			asw1.setUserName(aw1.getWork().getUser().getUserName());
			asw.add(asw1);
			
			
		}
		
		return asw;
		
	}
	
	
	@GetMapping("/contractorlistByPincode/{userId}")
	public List<LabourUserContractorDto> getallcontractorforlaabourpincode(@PathVariable int userId)
	{
		User user = this.userService.getUserById(userId);
		String pincode = user.getPincode();
		
		List<Contractor> cl = this.contractorService.getAllcContractorByPincode(pincode);
		
		List<LabourUserContractorDto> l1  = new ArrayList<LabourUserContractorDto>();
		
		ListIterator<Contractor> i = cl.listIterator();
		while(i.hasNext())
		{
			Contractor c = (Contractor)i.next();
			LabourUserContractorDto l = new LabourUserContractorDto();
			l.setAddress(c.getUser().getAddress());
			l.setContractorId(c.getContractorId());
			l.setEmailId(c.getUser().getEmailId());
			l.setExpiryDate(c.getExpiryDate());
			l.setLiceneNo(c.getLicenceNo());
			l.setMobileNo(c.getUser().getMobileNo());
			l.setPincode(c.getUser().getPincode());
			l.setUserName(c.getUser().getUserName());
			
			l1.add(l);
			
			
		}
		
		return l1;
		
		
		
	}

}
