package com.project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AssignedWorkDto;
import com.project.dto.BiddingUserWorkdto;
import com.project.dto.LabourUserContractorDto;
import com.project.dto.requestContractorLabourDto;
import com.project.pojos.AssignedWork;
import com.project.pojos.Bidding;
import com.project.pojos.Contractor;
import com.project.pojos.Labour;
import com.project.pojos.Requests;
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
import com.project.service.RequestService;
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
	@Autowired
	RequestService requestService;

	// GetUSerdataForContractorId
	@GetMapping("/getdataBycontractorId/{contractorId}")
	public User getuserdatabyContractorId(@PathVariable int contractorId) {

		Contractor contractor = this.contractorService.getContractorByContractorId(contractorId);
		User user = contractor.getUser();
		// int userId = user.getUserId();
		return user; // this.userService.getUserById(userId);
	}

	// update professional details
	@PostMapping("/updatecontractorProfessionalDetails/{userId}")
	public String UpdateContractor(@RequestBody Contractor contractor, @PathVariable int userId) {
		User user = this.userService.getUserById(userId);
		contractor.setUser(user);
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
	
	
	//accept request
	@GetMapping("/acceptrequest/{requestId}")
	public ResponseEntity<HttpStatus> acceptRequest(@PathVariable int requestId)
	{
		Requests request = this.requestService.getRequestByRequestId(requestId);
		Contractor contractor = request.getContractor();
		Labour labour = request.getLabour();
		labour.setContractor(contractor);
		this.labourService.addLabour(labour);
		
		this.deleteRequest(requestId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	//getAllRequestsByContractorId
	@GetMapping("/getallrequestbycontractorid/{contractorId}")
	public List<Requests> getAllRequestsByContractorId(@PathVariable int contractorId)
	{
		return this.requestService.getAllRequestsByContractorId(contractorId);
	}
	
	
	///////////===========================================================
	@GetMapping("/getBiddingsdetailsforContractor/{contractorId}")
	public List<BiddingUserWorkdto> getAllBiddingDetailsForContractor(@PathVariable int contractorId)
	{
		List<Bidding> bl = this.biddingService.getBiddingByContractorId(contractorId);
		
		ListIterator<Bidding> i = bl.listIterator();
		List<BiddingUserWorkdto> buw = new ArrayList<BiddingUserWorkdto>();
		while (i.hasNext())
		{
			Bidding b = (Bidding)i.next();
			Work w = this.workService.getWorkByWorkId(b.getWork().getWorkId());
			User u = this.userService.getUserById(w.getUser().getUserId());
			
			BiddingUserWorkdto obj = new BiddingUserWorkdto();
			obj.setBamount(b.getAmount());
			obj.setBdescription(b.getDescription());
			obj.setBfromDate(b.getFromDate());
			obj.setBiddingId(b.getBiddingId());
			obj.setBstatus(b.getStatus());
			obj.setBtoDate(b.getToDate());
			obj.setUserId(u.getUserId());
			obj.setUserName(u.getUserName());
			obj.setWdescription(w.getDescription());
			obj.setWorkId(w.getWorkId());
			obj.setWtitle(w.getTitle());
			
			buw.add(obj);

		}
		
		return buw;		
	}
	
	
	
	
	@GetMapping("/getalldata/AssignedWork/{contractorId}")
	public List<AssignedWorkDto> getalldataAssignedWorkById(@PathVariable int contractorId)
	{
		
		List<AssignedWork> aw = this.assignedWorkService.getAssignedWorkByContractorsId(contractorId);
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
	
	
	@GetMapping("/getAllLaboursForContractor/{contractorId}")
	public List<LabourUserContractorDto> getAllLaboursBYCOntractorId(@PathVariable int contractorId)
	{
		List<Labour> ll = this.labourService.getLabourByContractorId(contractorId);
		List<LabourUserContractorDto> luc = new ArrayList<LabourUserContractorDto>();
		
		ListIterator<Labour> i = ll.listIterator();
		while(i.hasNext())
		{
			Labour l = (Labour) i.next();
			LabourUserContractorDto lc = new LabourUserContractorDto();
			lc.setUserId(l.getUser().getUserId());
			lc.setUserName(l.getUser().getUserName());
			lc.setAddress(l.getUser().getAddress());
			lc.setEmailId(l.getUser().getEmailId());
			lc.setMobileNo(l.getUser().getMobileNo());
			lc.setPincode(l.getUser().getPincode());
			lc.setLabourId(l.getLabourId());
			
			luc.add(lc);
		}
		return luc;
		
		
	}
	
	
	@GetMapping("/getAllRequests/{contractorId}")
	public List<requestContractorLabourDto> getAllrequestByContractorId(@PathVariable int contractorId)
	{
		List<Requests> rl =this.requestService.getAllRequestsByContractorId(contractorId);
		List<requestContractorLabourDto> rcl = new ArrayList<requestContractorLabourDto>();
		ListIterator<Requests> i = rl.listIterator();
		while(i.hasNext()) {
			Requests r = (Requests) i.next();
			requestContractorLabourDto obj = new requestContractorLabourDto();
			obj.setAddress(r.getLabour().getUser().getAddress());
			obj.setContractorId(contractorId);
			obj.setEmailId(r.getLabour().getUser().getEmailId());
			obj.setExpiryDate(r.getContractor().getExpiryDate());
			obj.setLabourId(r.getLabour().getLabourId());
			obj.setLiceneNo(r.getContractor().getLicenceNo());
			obj.setMobileNo(r.getLabour().getUser().getMobileNo());
			obj.setNote(r.getNote());
			obj.setPincode(r.getLabour().getUser().getPincode());
			obj.setRequestid(r.getRequestid());
			obj.setUserId(r.getLabour().getUser().getUserId());
			obj.setUserName(r.getLabour().getUser().getUserName());
			rcl.add(obj);
			
		}
	return rcl;
	}
	
	@Transactional
	@Modifying
	@DeleteMapping("/DeleteRequest/{requestId}")
	public void deleteRequest(@PathVariable int requestId)
	{	
		
		this.requestService.deleterequestfromtable(requestId);
	}

}
